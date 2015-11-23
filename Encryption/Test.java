import java.io.File;


public class Test {

	public static void main(String[] args) {

		/*
		 * I left this test main class to see easily how to use the Encryption class.
		 * Everything is static so you will not have to make an object.
		 */

		
		// This is an example of how to make a file path that works, Java does not like the / so use File.separator instead
		String s = "X:" + File.separator + "workspace" + File.separator + "Encrpyt" + File.separator + "src" + File.separator + "testFile.txt";
		
		// This is a way to make an lazy key to test the class
		int[] key = new int[32]; // THE KEY MUST BE INT[32]
		key[0] = 1;
		for(int i = 0;i < 32; i++){
			key[i] = 4*i  + key[i];
		}
		
		
		System.out.println("Encryption start");
		
		// This is the function call that will read in the file, encrypt it, then write the file out
		// startEncrypt(String, int[32]) will handle file sizes not divisible by 8 automatically
		Encryption.startEncrypt(s,key);
		
		System.out.println("Encryption end");
		System.out.println("\n\n");
		System.out.println("Decryption start");
		
		// This is the function call that will read in the file, decrypt it, then write the file out
		// startDecrypt(String, int[32])
		Encryption.startDecrypt(s,key);
		
		System.out.println("Decryption end");
	}

}
