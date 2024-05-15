package co.edu.unbosque.forestbet.formulamodule.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class HttpConnectionsAndRequests {
	/**
	 * <PARA LA ULTIMA CARRERA (SOBRE LA QUE SE VA A HACER LA APUESTA>
	 * http://ergast.com/api/f1/current/next.json
	 * 
	 * <PARA LOS PILOTOS>
	 * http://ergast.com/api/f1/current/drivers.json
	 * 
	 * <PARA LAS SCUDERIAS>
	 * http://ergast.com/api/f1/current/constructors.json
	 * 
	 * <PARA LOS CIRCUITOS>
	 * http://ergast.com/api/f1/current/circuits.json
	 * 
	 * <PARA LAS CARRERAS>
	 * http://ergast.com/api/f1/current/races.json
	 * 
	 */
	
	public static String doARequest(String url, String method) {
        System.out.println(url);
        
        try {
        	HttpURLConnection connection = (HttpURLConnection) new URL(url.toString()).openConnection();
			connection.setRequestMethod(method);
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuilder response = new StringBuilder();
			
			String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();
            
            // Imprime la respuesta del servidor
            System.out.println("Respuesta del servidor: " + response.toString());

            // Cierra la conexión
            connection.disconnect();
            return response.toString();
		} catch (ProtocolException e) {
			e.printStackTrace();
			return e.toString();
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return e.toString();
		} catch (IOException e) {
			e.printStackTrace();
			return e.toString();
		}
	}
}
