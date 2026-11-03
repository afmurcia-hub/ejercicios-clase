import React, { useState, useEffect } from 'react';

const API_URL = 'http://localhost:8080/api';

export default function App() {

  const [estadoLuz, setEstadoLuz] = useState({ encendida: false, ubicacion: '', historial: [] });
  const [cargando, setCargando] = useState(false);

  
  const consultarEstado = async () => {
    try {
      const respuesta = await fetch(`${API_URL}/estado`);
      const datos = await respuesta.json();
      setEstadoLuz(datos);
    } catch (error) {
      console.error('Error de conexión con el backend en Java:', error);
    }
  };

  useEffect(() => {
    consultarEstado();
  }, []);

  const enviarComando = async (endpoint) => {
    setCargando(true);
    try {
      const respuesta = await fetch(`${API_URL}/${endpoint}`);
      const datos = await respuesta.json();
      setEstadoLuz(datos);
    } catch (error) {
      alert('Asegúrate de que el backend en Java (ServidorWeb) esté ejecutándose en http://localhost:8080');
    } finally {
      setCargando(false);
    }
  };

  return (
    <div style={estilos.contenedor}>
      <div style={estilos.tarjeta}>
        <h2>Control Remoto (Frontend React + Backend Java)</h2>
        <p style={{ color: '#666', fontSize: '14px' }}>
          Patrón Comando ejecutado en el servidor Java
        </p>
        
        <div style={{
          ...estilos.cajaEstado,
          backgroundColor: estadoLuz.encendida ? '#fff3cd' : '#e2e3e5',
          color: estadoLuz.encendida ? '#856404' : '#383d41'
        }}>
          {estadoLuz.encendida ? '💡 Luz ENCENDIDA' : '🌑 Luz APAGADA'}
        </div>

        <div style={estilos.grupoBotones}>
          <button style={estilos.boton} onClick={() => enviarComando('encender')} disabled={cargando}>
            💡 Encender
          </button>
          <button style={estilos.boton} onClick={() => enviarComando('apagar')} disabled={cargando}>
            🌑 Apagar
          </button>
          <button 
            style={{ ...estilos.boton, ...(estadoLuz.historial.length === 0 ? estilos.botonDeshabilitado : {}) }} 
            onClick={() => enviarComando('deshacer')}
            disabled={cargando || estadoLuz.historial.length === 0}
          >
            ↩️ Deshacer (Undo)
          </button>
        </div>

        <div style={estilos.seccionHistorial}>
          <h4>Historial en el Invocador Java (Backend):</h4>
          {estadoLuz.historial.length === 0 ? (
            <p style={{ color: '#888' }}>(No hay comandos en el historial Java)</p>
          ) : (
            <ul>
              {estadoLuz.historial.map((comando, i) => (
                <li key={i}>{i + 1}. {comando}</li>
              ))}
            </ul>
          )}
        </div>
      </div>
    </div>
  );
}

const estilos = {
  contenedor: { fontFamily: 'sans-serif', padding: '40px', textAlign: 'center', backgroundColor: '#f4f7f6', minHeight: '100vh' },
  tarjeta: { backgroundColor: 'white', padding: '30px', borderRadius: '10px', display: 'inline-block', boxShadow: '0 4px 10px rgba(0,0,0,0.1)', maxWidth: '480px', width: '100%' },
  cajaEstado: { padding: '15px', fontSize: '20px', fontWeight: 'bold', margin: '20px 0', borderRadius: '5px' },
  grupoBotones: { display: 'flex', gap: '10px', justifyContent: 'center', flexWrap: 'wrap' },
  boton: { padding: '10px 15px', fontSize: '14px', cursor: 'pointer', borderRadius: '5px', border: 'none', backgroundColor: '#007bff', color: 'white', fontWeight: 'bold' },
  botonDeshabilitado: { backgroundColor: '#cccccc', cursor: 'not-allowed' },
  seccionHistorial: { textAlign: 'left', marginTop: '20px', borderTop: '1px solid #eee', paddingTop: '10px' }
};
