/* * * * * * * * * * * * * * 
* Forfattere:
* Josephine Søgaard Andersen, josea18@student.sdu.dk
* Josias Kure, joulr18@student.sdu.dk 
* Kasper Jonassen, kajon18@student.sdu.dk
* * * * * * * * * * * * * */

    
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class Encode {
	public static int[] frequency = new int[256];
	//public static FileInputStream inputFile;
	//public static FileOutputStream outputFile;
	public static String argument0;
	public static String argument1;
	public static byte[] bitsForTest = new byte[256];
	public static PQ pq = new PQHeap(256);
	public static int n;

	//public static PQ pq;


	//int i =0;




	public static void main(String[] args) throws Exception{

	//int q;
	//int z;
	/*
	 * Scanner inputfilen og indsætter i array
	 */

		FileInputStream inputFile = new FileInputStream(args[0]);
        FileOutputStream outputFile = new FileOutputStream(args[1]);
		BitInputStream in = new BitInputStream(inputFile);
		BitOutputStream out = new BitOutputStream(outputFile);

		//Skal vist nok være et int-array ifølge Rolf - MÅSKE!
		
		
		


		/* Scans file
		*/
		int counter = 0;
		while(counter < 256){
			int x = in.readInt();
			frequency[counter] = (byte)x;
			counter++;
			}

		/* indsætter fra arrayet til prioritetskø */ 
		for (int i = 0; i < 256; i++){
			//z = i;
			//q = frequency[i];
			int q = frequency[i];
			pq.insert(new Element(q,i));
			n++;		
		}
		//Huffman();

		outputFile.write(bitsForTest);
		// Man kan pt. ikke overskrive filer. TEST EVT TIL SIDST


	}

/*
	public static void Huffman() throws IOException{
	/*
	 * Baseret på pseudokoden fra bogen
	 * we assume that C is a set of n characters and
		that each character c 2 C 
		is an object with an attribute c:freq giving its frequency.

		Q = queue
	 */


	 //int n = C; //antallet af characters i filnummer1
	 //Q = C; // min-priority queue
	// int n = bitsForTest.length; 
	// System.out.println(n);
	// n kommer fra forrige metode
/*	 for (int i = 0; i < n-1 ; i++){
		Element[] element = new Element[2];
		element[0] = pq.extractMin();
		element[1] = pq.extractMin();
		int freq = element[0].getKey() + element[1].getKey();
		pq.insert(new Element(freq,element));
			 
		}
		Element elem = pq.extractMin(); //returns to root

		//return(pq.extractMin());

	
	}

	*/
