package main;

import controller.Controller;
import dados.DadosServidor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Lucas de Liz Frutuoso e Matheus Henrique Maas
 */
public class PrincipalServidor {

    private static Socket socket;
    private static ServerSocket serverSocket;
    private static PrintWriter mensagemDados;
    private static Controller controller;
    private static DadosServidor popularServidor;

    public static void main(String[] args) throws IOException, ParseException, java.text.ParseException {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Qual a porta?");
        int porta = entrada.nextInt();

        serverSocket = new ServerSocket(porta);
        serverSocket.setReuseAddress(true);
        controller = new Controller();
        popularServidor = new DadosServidor();
        System.out.println("Servidor iniciado---");
        //popularServidor.popularDadosServidor();

        while (true) {
            recebeDados();
        }

    }

    public static void recebeDados() throws IOException, ParseException, java.text.ParseException {

        socket = serverSocket.accept();
        String clienteIp = socket.getInetAddress().getHostAddress();
        System.out.println(clienteIp + " Conectou neste momento---");

        InputStreamReader in = new InputStreamReader(socket.getInputStream());
        BufferedReader br = new BufferedReader(in);
        String mensagem = br.readLine();

        String retorno = controller.Dados(mensagem);
        enviaDados(retorno);
        System.out.println(retorno);
    }

    public static void enviaDados(String msg) throws IOException {

        mensagemDados = new PrintWriter(socket.getOutputStream());
        mensagemDados.println(msg);
        mensagemDados.flush();
    }

}
