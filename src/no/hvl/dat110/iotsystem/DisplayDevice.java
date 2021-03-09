package no.hvl.dat110.iotsystem;

import no.hvl.dat110.client.Client;
import no.hvl.dat110.messages.Message;
import no.hvl.dat110.messages.PublishMsg;

public class DisplayDevice {

	private static final int COUNT = 10;

	public static void main(String[] args) {

		System.out.println("Display starting ...");

		// TODO - START

		// create a client object and use it to

		Client client = new Client("Display", Common.BROKERHOST, Common.BROKERPORT);

		// - connect to the broker
		client.connect();
		// - create the temperature topic on the broker
		client.createTopic(Common.TEMPTOPIC);
		// - subscribe to the topic
		client.subscribe(Common.TEMPTOPIC);
		// - receive messages on the topic
		int i = 0;
		while (i < COUNT) {

			Message msg = client.receive();

			System.out.println(msg.toString());

			i++;
		}
		// - unsubscribe from the topic
		client.unsubscribe(Common.TEMPTOPIC);
		// - disconnect from the broker
		client.disconnect();

		// TODO - END

		System.out.println("Display stopping ... ");

	}
}
