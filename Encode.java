/* * * * * * * * * * * * * * 
 * Forfattere:
 * Josephine Søgaard Andersen, josea18@student.sdu.dk
 * Josias Kure, joulr18@student.sdu.dk 
 * Kasper Jonassen, kajon18@student.sdu.dk


 Vi har desværre haft lidt problemer med implementeringen af Huffmans algoritme i denne aflevering. 
 Umiddelbart ser Encode.java ud til at virke, da vi modtager et komprimeret output. Problemet har 
 særligt været at få Huffman algoritmen til at modtage inputs fra de resterende metoder i Encode.java. 

 Med hensyn til Decode.java, har vi ikke formået at decode det output, vi modtog fra Encode.java. 
 Klassen ser derimod ud til at komprimere vores output endnu engang. Vi antager, det skyldes fejl i 
 vores Encode.java, men vi har desværre ikke kunne gennemskue hvori fejlen ligger. 
 Det er blandt andet derfor Decode.java ikke kan compile.
 I Decode.java forsøgte vi at vende koden fra Encode.java om, men det fungerede ikke.

 I begge klasser har der hovedsageligt været problemer med vores arrays eller de løkker, 
 vi har brugt til at gå igennem arrayet. I både while- og for-løkker stødte vi jævnligt på fejlen 
 ArrayOutOfBounds, hvilket i sidste ende førte til de løkker, der ses i de afleverede filer. 
 Det er dog ikke et problem vi har formået at løse i Decode.java.

 * * * * * * * * * * * * * */


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class Encode{

	public static FileInputStream inputFile;
	public static FileOutputStream outputFile;
	public static String argument0;
	public static String argument1;
	public static int[] frequency = new int[256];
	public static PQ pq = new PQHeap(256);
	public static BitInputStream input;
	public static BitOutputStream output;
	public static int numberOfBytesRead;
	public static int i;
	

	/*
	 * Input- og output-filen deklareres fra argumenterne fra commandline
	 */
	public static void main(String[] args) throws Exception{

	 	argument0 = args[0];
		argument1 = args[1];
		ScanFile();
		Huffman();
		WriteToOutput();
	}

	/*
	 * Vi indlæser input-filen og udskriver den til outputfilen.
	 * Der bruges et forloop til at læse filen og kopiere den over til arrayet frequency
	 */
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
		System.out.println("Debug: While-løkke kørt");
	}


	/*
	 * Vores huffmankode er baseret på pseudokoden fra bogen, s. 431.
	 * Ved at finde de to mindste keys, beregner vi frekvensen.
	 * Til sidst returnerer vi til roden af træet.
	 */
	public static void Huffman() throws IOException{

	 for (int i = 0; i < numberOfBytesRead-1 ; i++){
		Element[] element = new Element[2];
		element[0] = pq.extractMin();
		element[1] = pq.extractMin();
		int key = element[0].getKey() + element[1].getKey();
		pq.insert(new Element(key, element)); 
		}

	Element tempElement = pq.extractMin(); //returnerer til roden	
	System.out.println("Debug: Huffman-algoritme kørt");
	}

	/* 
	 * Et forsøg på at udskrive key til vores outputfil
	 */
	public static void WriteToOutput() throws IOException{

		for(int k = 0; k < numberOfBytesRead; k++){
			int x = frequency[k];
			output.writeInt(x);
		}
		System.out.println("Debug: WriteToOutPut kørt");
	}
}