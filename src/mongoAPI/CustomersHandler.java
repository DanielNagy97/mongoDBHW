package mongoAPI;

import static com.mongodb.client.model.Filters.eq;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class CustomersHandler extends Methods implements Handler {

	@Override
	public MongoCollection<Document> getAll(MongoDatabase db) {
		return query(db, "customers");
	}

	@Override
	public void addNew(MongoDatabase db, Scanner scanner) {
		Document newCostumer = new Document();
		System.out.println("Vasarlo _id-je:");
		newCostumer.put("_id", Float.parseFloat(scanner.nextLine()));

		System.out.println("Vasarlo neve:");
		newCostumer.put("name", scanner.nextLine());

		System.out.println("Email-cime:");
		newCostumer.put("email", scanner.nextLine());

		newCostumer.put("purchases", new ArrayList<>());

		insert(db, "customers", newCostumer);
	}

	@Override
	public void updateOne(MongoDatabase db, Scanner scanner) {
		System.out.println("Mit szeretne módosítani?");
		System.out.println("1. Vevő neve");
		System.out.println("2. Vevő email-címe");
		System.out.println("0. Visszalépés");
		int input2 = Integer.parseInt(scanner.nextLine());
		Float id;
		String newVal;
		switch (input2) {
		case 1:
			System.out.println("Adja meg az _id-t:");
			id = Float.parseFloat(scanner.nextLine());
			System.out.println("Adja meg az új nevet:");
			newVal = scanner.nextLine();

			update(db, "customers", id, "name", newVal);
			break;

		case 2:
			System.out.println("Adja meg az _id-t:");
			id = Float.parseFloat(scanner.nextLine());
			System.out.println("Adja meg az új email címet:");
			newVal = scanner.nextLine();

			update(db, "customers", id, "email", newVal);
			break;

		case 0:
			break;
		default:
			break;
		}
	}

	@Override
	public void deleteOne(MongoDatabase db, Scanner scanner) {
		System.out.println("Adja meg az _id-t:");
		Float id = Float.parseFloat(scanner.nextLine());

		deleteById(db, "customers", id);
	}

	public void makeNewOrder(MongoDatabase db, Scanner scanner) {
		System.out.println("Adja meg a vásárló _id-ját:");
		Float id = Float.parseFloat(scanner.nextLine());
		System.out.println("Hány terméket vásárolt?:");
		int input2 = Integer.parseInt(scanner.nextLine());
		Float newFloatVal;

		ArrayList<Document> purchasedAlbums = new ArrayList<>();

		for (int i = 0; i < input2; i++) {
			System.out.println("Adja meg az " + i + ". album _id-jét:");
			newFloatVal = Float.parseFloat(scanner.nextLine());
			purchasedAlbums.add(new Document("_id", newFloatVal));
		}
		System.out.println("Adja meg a végösszeget:");
		newFloatVal = Float.parseFloat(scanner.nextLine());

		newPurchase(db, id, purchasedAlbums, newFloatVal);
	}
	
	public void newPurchase(MongoDatabase db, Float id, ArrayList<Document> purchasedAlbums, Float price) {
		try {
			MongoCollection<Document> collection = db.getCollection("customers");
			Document purchase = new Document();
			purchase.put("date", new Date());
			purchase.put("albums", purchasedAlbums);
			purchase.put("price", price);

			collection.updateOne(eq("_id", id), new Document("$push", new Document("purchases", purchase)));
			System.out.println("OK");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
