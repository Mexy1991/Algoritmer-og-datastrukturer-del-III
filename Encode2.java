import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class Encode2{

	public static int[] frequency = new int[256];
	public static FileInputStream inFile;
	public static FileOutputStream outFile;
	public static String argument0;
	public static String argument1;
	public static byte[] bitsForTest = new byte[256];
	int i = 0;
	int counter;
	public static PQ pq = new PQHeap(256);
	public static int q;
	public static int n;
	public static BitInputStream in;
	public static BitOutputStream out;





	public static void main(String[] args) throws Exception{
	/*
	 * Scanner inputfilen og indsætter i array
	 */

	 	argument0 = args[0];
		argument1 = args[1];

		ScanFile();
        //Huffman();



	}


	public static void ScanFile() throws IOException{

		//FileInputStream inputFile = new FileInputStream(argument0);
		//FileOutputStream outputFile = new FileOutputStream(argument1);
		//BitInputStream in = new BitInputStream(inputFile);
		//BitOutputStream out = new BitOutputStream(outputFile);



		int q;
		int z;
		// loading file from path to input stream / output stream
		inFile = new FileInputStream(argument0);
		outFile = new FileOutputStream(argument1);
		in = new BitInputStream(inFile);
		out = new BitOutputStream(outFile);
		n = 0;
		
		//reads byte for byte from input stream and counts each byte that gets stored in bitsArray
		int content;
		while ((content = inFile.read()) != -1)
		{
			frequency[content] = frequency[content] + 1;
		}
		
		
//		Inserts new elements from bitsArray to Priority queue
		for(int i = 0; i < 256; i++)
		{
			z = i;
			q = frequency[i];
			pq.insert(new Element(q,z));
			n++;
		}
		

		


		//int n = 0;
		/*inputFile.read(bitsForTest);

		for (int i = 0; i < 256; i++){
			q = frequency[i];
            pq.insert(new Element(q,i));
			i++;

			*/


		
		}

		public static void bitToOutput() throws IOException{		
			inFile = new FileInputStream(argument0);
			outFile = new FileOutputStream(argument1);
			int content;
			String strBit;
			String cont;
		
			for(int i = 0; i < frequency.length; i++){
				int x = frequency[i];
				out.writeInt(x);
			}k
	


		}

	


//	public static void Huffman(){
		//side 431
	//}


    /* indsætter fra arrayet til prioritetskø */ 
	/*
		for (int i = 0; i < 256; i++){
			//z = i;
			//q = frequency[i];
			int q = frequency[i];
			pq.insert(new Element(q,i));
			n++;		
		}
		*/
		//outputFile.write(bitsForTest);	



}