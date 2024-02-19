package ru.rusalitc.java.basic.homework13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8088);

            BufferedReader inMessage = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter outMessage = new PrintWriter(socket.getOutputStream(), true);

            String serverMessage = inMessage.readLine();
            System.out.println(serverMessage);

            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите первое число:");
            String firstValue = scanner.nextLine();
            float x = Float.parseFloat(firstValue);
            outMessage.println(x);

            System.out.println("Введите второе число:");
            String secondValue = scanner.nextLine();
            float y = Float.parseFloat(secondValue);
            outMessage.println(y);

            System.out.println("Введите операцию (+, -, *, /):");
            String mathOp = scanner.nextLine();
            outMessage.println(mathOp);

            String result = inMessage.readLine();
            System.out.println(result);

            inMessage.close();
            outMessage.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}