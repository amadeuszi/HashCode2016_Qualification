package com.kosior.hash;

import com.kosior.hash.model.Dron;
import com.kosior.hash.model.GameSettings;
import com.kosior.hash.model.Order;
import com.kosior.hash.model.Warehouse;

import java.util.Scanner;

public class InputReaderAndParser {

	public static Scanner scanner = new Scanner(System.in);

	public static GameSettings readAndParseInput() {
		GameSettings gameSettings = new GameSettings();

		gameSettings.rows = scanner.nextInt();
		gameSettings.columns = scanner.nextInt();
		gameSettings.dronesNumber = scanner.nextInt();
		gameSettings.maxTurnsNumber = scanner.nextInt();
		gameSettings.maxDronePayload = scanner.nextInt();
		gameSettings.numberOfProductTypes = scanner.nextInt();

		for (int i = 0; i < gameSettings.numberOfProductTypes; ++i) {
			gameSettings.productTypesWeight.add(scanner.nextInt());
		}

		gameSettings.numberOfWarehouse = scanner.nextInt();

		for (int i = 0; i < gameSettings.numberOfWarehouse; ++i) {
			Warehouse warehouse = new Warehouse();
			warehouse.row = scanner.nextInt();
			warehouse.column = scanner.nextInt();
			warehouse.id = i;

			for (int j = 0; j < gameSettings.numberOfProductTypes; ++j) {
				warehouse.numberOfProducts.add(j, scanner.nextInt());
			}

			gameSettings.warehouses.add(warehouse);
		}

		gameSettings.numberOfOrders = scanner.nextInt();

		for (int i = 0; i < gameSettings.numberOfOrders; ++i) {
			Order order = new Order();
			order.row = scanner.nextInt();
			order.column = scanner.nextInt();
			order.numberOfItems = scanner.nextInt();
			order.id = i;

			for (int j = 0; j < order.numberOfItems; ++j) {
				int item = scanner.nextInt();
				if (order.productsNeeded.containsKey(item)) {
					int currentValue = order.productsNeeded.get(item);
					order.productsNeeded.replace(item, currentValue + 1);
				} else {
					order.productsNeeded.put(item, 1);
				}

				order.totalWeights += gameSettings.productTypesWeight.get(item);
			}

			gameSettings.orders.add(order);
		}

		// Drony na poczatku sa w pierwszym warehouse
		Warehouse initialWarehouse = gameSettings.warehouses.get(0);
		for (int i = 0; i < gameSettings.dronesNumber; ++i) {
			Dron dron = new Dron();
			dron.column = initialWarehouse.column;
			dron.row = initialWarehouse.row;
			dron.id = i;

			gameSettings.drones.add(dron);
		}

		return gameSettings;
	}

}
