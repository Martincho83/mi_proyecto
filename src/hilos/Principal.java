package hilos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class Principal {
	
	public static void main(String[] args) {
		Runnable tareaLectura = () -> {
			String nombreArchivo = "archivo.txt";
			try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
				String linea;
				while ((linea = br.readLine()) != null) {
					System.out.println(linea);
		                }
		            } catch (IOException e) {
		                e.printStackTrace();
		            }
		        };

		        Thread hiloLector = new Thread(tareaLectura);
		        hiloLector.start();
		        
		        for (int i = 0; i < 10; i++) {
		            System.out.println("Hilo principal trabajando");
		            try {
		                Thread.sleep(1000);
		            } catch (InterruptedException e) {
		                e.printStackTrace();
		            }
		        }
		    }
}