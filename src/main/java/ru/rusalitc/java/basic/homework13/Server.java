package ru.rusalitc.java.basic.homework13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        try {
            ServerSocket serverSocket = new ServerSocket(8088);

            Socket socket = serverSocket.accept();
            System.out.println("Клиент подключен");

            BufferedReader inMessage = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter outMessage = new PrintWriter(socket.getOutputStream(), true);
            outMessage.println("Вы подключились к серверу к приложению 'Калькулятор', Вам доступны следующие операции: +, -, *, / над двумя числами");

            float x = Float.parseFloat(inMessage.readLine());
            float y = Float.parseFloat(inMessage.readLine());
            String mathOp = inMessage.readLine();
            if (operation(x, y, mathOp).equals("Введена неккоректная операция")) {
                outMessage.println("Введена неккоректная операция");
            } else {
                outMessage.println(x + " " + mathOp + " " + y + " = " + operation(x, y, mathOp));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String operation(float a, float b, String s) {
        switch (s) {
            case "+":
                return Float.toString(a + b);
            case "-":
                return Float.toString(a - b);
            case "*":
                return Float.toString(a * b);
            case "/":
                return Float.toString(a / b);
            default:
                return "Введена неккоректная операция";
        }
    }

}