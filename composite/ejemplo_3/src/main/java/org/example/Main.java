package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // 1. Crear archivos individuales (Hojas)
        FileComponent file1 = new File("archivo1.txt");
        FileComponent file2 = new File("archivo2.txt");
        FileComponent file3 = new File("archivo3.txt");

        // 2. Crear directorios (Composites)
        Directory folder1 = new Directory("folder_1");
        Directory folder2 = new Directory("folder_2");



        // 3. Llenar el directorio 1 con archivos
        folder1.addComponent(file1);
        folder1.addComponent(file2);

        // 4. Llenar el directorio 2 con un archivo y anidar el directorio 1 dentro de él
        folder2.addComponent(file3);
        folder2.addComponent(folder1);


        // 5. Mostrar detalles llamando a la raíz de manera uniforme
        folder2.showDetails();

    }
}