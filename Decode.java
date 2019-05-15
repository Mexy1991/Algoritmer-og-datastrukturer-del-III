/* * * * * * * * * * * * * * 
 * Forfattere:
 * Josephine Søgaard Andersen, josea18@student.sdu.dk
 * Josias Kure, joulr18@student.sdu.dk 
 * Kasper Jonassen, kajon18@student.sdu.dk
 * * * * * * * * * * * * * */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Decode{

	public static FileInputStream inputFile;
	public static FileOutputStream outputFile;
	public static BitInputStream input;
	public static BitOutputStream output;
	public static String argument0;
	public static String argument1;
	public static PQ pq = new PQHeap(256);
	public static int[] frequency = new int[256];

	public static void main(String[] args) throws Exception{
		argument0 = args[0];
		argument1 = args[1];

		ScanFile();
		Huffman();
	}
		public static void ScanFile() throws IOException{

		inputFile = new FileInputStream(argument0);
		outputFile = new FileOutputStream(argument1);
		input = new BitInputStream(inputFile); 
		output = new BitOutputStream(outputFile);

		int i = input.readInt();
		System.out.println(i);
		output.writeInt(i);
		
		int bit;
		int temp;
		int counter = 0;

		while ((bit = input.readBit()) != -1 ){
			output.writeBit(bit);
		
		if(counter < 256){
			temp=input.readBit();
			frequency[counter]=temp;
			counter++;
			}
		}
		int numberOfBytesRead = counter;
		System.out.println("Debug ude af while");
	}

	/*
	 * Vores huffmankode er baseret på pseudokoden fra bogen, s. 431.
	 * Ved at finde de to mindste keys, beregner vi frekvensen.
	 * Til sidst returnerer vi til roden af træet.
	 */
	public static void Huffman() throws IOException{
		int n = 256;
		for (int i = 0; i < n-1 ; i++){
			Element[] element = new Element[2];
			element[0] = pq.extractMin();
			element[1] = pq.extractMin();
			int key = element[0].getKey() + element[1].getKey();
			pq.insert(new Element(key, element)); 
			}

		Element tempElement = pq.extractMin(); //returns to root	
		System.out.println("Debug: Huffman-algoritme færdig!");
	}
}