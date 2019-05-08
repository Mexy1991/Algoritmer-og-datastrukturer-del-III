/* * * * * * * * * * * * * * 
* Forfattere:
* Josephine Søgaard Andersen, josea18@student.sdu.dk
* Josias Kure, joulr18@student.sdu.dk 
* Kasper Jonassen, kajon18@student.sdu.dk
* * * * * * * * * * * * * */

    
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Encode {
	public static int[] frequency = new int[256];
	//public static FileInputStream inputFile;
	//public static FileOutputStream outputFile;
	public static String argument0;
	public static String argument1;
	public static byte[] bitsForTest = new byte[256];


	int i =0;





	public static void main(String[] args) throws Exception{
	/*
	 * Scanner inputfilen og indsætter i array
	 */

		FileInputStream inputFile = new FileInputStream(args[0]);
        FileOutputStream outputFile = new FileOutputStream(args[1]);
		//Skal vist nok være et int-array ifølge Rolf - MÅSKE!
		inputFile.read(bitsForTest);
		outputFile.write(bitsForTest);

	}


	//public Huffman(){
	/*
	 * Baseret på pseudokoden fra bogen
	 * we assume that C is a set of n characters and
		that each character c 2 C 
		is an object with an attribute c:freq giving its frequency.

		Q = queue
	 */

	
	//}
		 




}