package br.com.energia.energia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.InetSocketAddress;
import java.net.Socket;

@SpringBootApplication
public class EnergiaApplication {

	public static void main(String[] args) {
		// Detecta se o Oracle local (Docker) está disponível
		boolean localOracleAtivo = isHostReachable("oracle-db", 1521);

		if (localOracleAtivo) {
			System.setProperty("DB_URL", "jdbc:oracle:thin:@oracle-db:1521/FREEPDB1");
			System.out.println("✅ Usando Oracle local (docker-db)");
		} else {
			System.setProperty("DB_URL", "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL");
			System.out.println("🌎 Usando Oracle remoto (FIAP)");
		}

		SpringApplication.run(EnergiaApplication.class, args);
	}

	private static boolean isHostReachable(String host, int port) {
		try (Socket socket = new Socket()) {
			socket.connect(new InetSocketAddress(host, port), 2000);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
