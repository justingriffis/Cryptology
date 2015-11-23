import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class Encryption {

    private static int k0, k1, k2, k3, k4, k5, k6, k7,
    k8, k9, k10, k11, k12, k13, k14, k15,
    k16, k17, k18, k19, k20, k21, k22, k23,
    k24, k25, k26, k27, k28, k29, k30, k31;//Where the key gets stored

     /**
     * Set the encryption key used for encrypting and decrypting.
     * The key needs to be 16 bytes long.
     *
     * @param key is the key
     */

	public static void setKey(int[] r){
        k0 = r[0]; k1 = r[1]; k2 = r[2]; k3 = r[3];
        k4 = r[4]; k5 = r[5]; k6 = r[6]; k7 = r[7];
        k8 = r[8]; k9 = r[9]; k10 = r[10]; k11 = r[11];
        k12 = r[12]; k13 = r[13]; k14 = r[14]; k15 = r[15];
        k16 = r[16]; k17 = r[17]; k18 = r[18]; k19 = r[19];
        k20 = r[20]; k21 = r[21]; k22 = r[22]; k23 = r[23];
        k24 = r[24]; k25 = r[25]; k26 = r[26]; k27 = r[27];
        k28 = r[28]; k29 = r[29]; k30 = r[30]; k31 = r[31];
	}
	
	/**
	 * Will start the encryption process, is the only function needed to be called to encrypt a file
	 * For file name please use the example below
	 * String s = "X:" + File.separator + "workspace" + File.separator + "Encrpyt" + File.separator + "src" + File.separator + "testpic.jpg";
	 * This encryption function automatically handles file sizes not divisible by 8
	 * 
	 * @param fileName is the full file path
	 * @param key is an array of integers that HAS to be size 32
	 */
	
	public static void startEncrypt(String fileName,int[] key){
		Path filePath = Paths.get(fileName);
		try {
			byte[] Barray = java.nio.file.Files.readAllBytes(filePath);
			setKey(key);
			int len = Barray.length;
			int newLen = len + (8- len % 8);
			if(len % 8 != 0){
				byte[] holdArray = new byte[newLen - len];
				byte[] finBarray = new byte[newLen];
				System.arraycopy(Barray, 0, finBarray, 0, len);
				System.arraycopy(holdArray, 0, finBarray, len, holdArray.length);
				encrypt(finBarray,0,finBarray.length - 1);
				java.nio.file.Files.write(filePath, finBarray, StandardOpenOption.WRITE);
			}
			else
			{
				encrypt(Barray,0,Barray.length - 1);
				java.nio.file.Files.write(filePath, Barray, StandardOpenOption.WRITE);
			}
		} 
		catch (IOException e){
			System.out.println(e);
		}
	}
	
	/**
	 * Will start the encryption process, is the only function needed to be called to encrypt a file
	 * For file name please use the example below
	 * String s = "X:" + File.separator + "workspace" + File.separator + "Encrpyt" + File.separator + "src" + File.separator + "testpic.jpg";
	 * 
	 * @param fileName is the full file path
	 * @param key is an array of integers that HAS to be size 32
	 */
	
	public static void startDecrypt(String fileName,int[] key){
		Path filePath = Paths.get(fileName);
		try {
			byte[] Barray = java.nio.file.Files.readAllBytes(filePath);
			setKey(key);//needs to be int array of size 32
			decrypt(Barray,0,Barray.length - 1);
			java.nio.file.Files.write(filePath, Barray, StandardOpenOption.WRITE);
		}  
		catch (IOException e){
			System.out.println(e);
		}
	}
	
     /**
     * Encrypt a number of bytes. This is done in-place, that
     * means the bytes are overwritten.
     *
     * @param bytes the byte array
     * @param off the start index
     * @param len the number of bytes to encrypt
     */

	public static byte[] encrypt(byte[] bytes, int off, int len) {
        for (int i = off; i < off + len; i += 8) {
            bytes = encryptBlock(bytes, bytes, i);
        }
        return bytes;
    }
	
     /**
     * Decrypt a number of bytes. This is done in-place, that
     * means the bytes are overwritten.
     *
     * @param bytes the byte array
     * @param off the start index
     * @param len the number of bytes to decrypt
     */
	
    public static byte[] decrypt(byte[] bytes, int off, int len) {
        for (int i = off; i < off + len; i += 8) {
            bytes = decryptBlock(bytes, bytes, i);
        }
        return bytes;
    }
    
    /**
     * encryptBlock is the function that actually encrypts the data
     * 
     * @param in array of bytes going about to be encrypted
     * @param out array of bytes being returned
     * @param off the start index
     * @return
     */
    
    private static byte[] encryptBlock(byte[] in, byte[] out, int off) {
        int y = (in[off] << 24) | ((in[off + 1] & 255) << 16)
                | ((in[off + 2] & 255) << 8) | (in[off + 3] & 255);
        int z = (in[off + 4] << 24) | ((in[off + 5] & 255) << 16)
                | ((in[off + 6] & 255) << 8) | (in[off + 7] & 255);
        y += (((z << 4) ^ (z >>> 5)) + z) ^ k0;
        z += (((y >>> 5) ^ (y << 4)) + y) ^ k1;
        y += (((z << 4) ^ (z >>> 5)) + z) ^ k2;
        z += (((y >>> 5) ^ (y << 4)) + y) ^ k3;
        y += (((z << 4) ^ (z >>> 5)) + z) ^ k4;
        z += (((y >>> 5) ^ (y << 4)) + y) ^ k5;
        y += (((z << 4) ^ (z >>> 5)) + z) ^ k6;
        z += (((y >>> 5) ^ (y << 4)) + y) ^ k7;
        y += (((z << 4) ^ (z >>> 5)) + z) ^ k8;
        z += (((y >>> 5) ^ (y << 4)) + y) ^ k9;
        y += (((z << 4) ^ (z >>> 5)) + z) ^ k10;
        z += (((y >>> 5) ^ (y << 4)) + y) ^ k11;
        y += (((z << 4) ^ (z >>> 5)) + z) ^ k12;
        z += (((y >>> 5) ^ (y << 4)) + y) ^ k13;
        y += (((z << 4) ^ (z >>> 5)) + z) ^ k14;
        z += (((y >>> 5) ^ (y << 4)) + y) ^ k15;
        y += (((z << 4) ^ (z >>> 5)) + z) ^ k16;
        z += (((y >>> 5) ^ (y << 4)) + y) ^ k17;
        y += (((z << 4) ^ (z >>> 5)) + z) ^ k18;
        z += (((y >>> 5) ^ (y << 4)) + y) ^ k19;
        y += (((z << 4) ^ (z >>> 5)) + z) ^ k20;
        z += (((y >>> 5) ^ (y << 4)) + y) ^ k21;
        y += (((z << 4) ^ (z >>> 5)) + z) ^ k22;
        z += (((y >>> 5) ^ (y << 4)) + y) ^ k23;
        y += (((z << 4) ^ (z >>> 5)) + z) ^ k24;
        z += (((y >>> 5) ^ (y << 4)) + y) ^ k25;
        y += (((z << 4) ^ (z >>> 5)) + z) ^ k26;
        z += (((y >>> 5) ^ (y << 4)) + y) ^ k27;
        y += (((z << 4) ^ (z >>> 5)) + z) ^ k28;
        z += (((y >>> 5) ^ (y << 4)) + y) ^ k29;
        y += (((z << 4) ^ (z >>> 5)) + z) ^ k30;
        z += (((y >>> 5) ^ (y << 4)) + y) ^ k31;
        out[off] = (byte) (y >> 24);
        out[off + 1] = (byte) (y >> 16);
        out[off + 2] = (byte) (y >> 8);
        out[off + 3] = (byte) y;
        out[off + 4] = (byte) (z >> 24);
        out[off + 5] = (byte) (z >> 16);
        out[off + 6] = (byte) (z >> 8);
        out[off + 7] = (byte) z;
        return out;
    }
    
    /**
     * decryptBlock is the function that actually decrypts the data
     * 
     * @param in array of bytes going about to be decrypted
     * @param out array of bytes being returned
     * @param off the start index
     * @return
     */
    
    private static byte[] decryptBlock(byte[] in, byte[] out, int off) {
        int y = (in[off] << 24) | ((in[off + 1] & 255) << 16)
                | ((in[off + 2] & 255) << 8) | (in[off + 3] & 255);
        int z = (in[off + 4] << 24) | ((in[off + 5] & 255) << 16)
                | ((in[off + 6] & 255) << 8) | (in[off + 7] & 255);
        z -= (((y >>> 5) ^ (y << 4)) + y) ^ k31;
        y -= (((z << 4) ^ (z >>> 5)) + z) ^ k30;
        z -= (((y >>> 5) ^ (y << 4)) + y) ^ k29;
        y -= (((z << 4) ^ (z >>> 5)) + z) ^ k28;
        z -= (((y >>> 5) ^ (y << 4)) + y) ^ k27;
        y -= (((z << 4) ^ (z >>> 5)) + z) ^ k26;
        z -= (((y >>> 5) ^ (y << 4)) + y) ^ k25;
        y -= (((z << 4) ^ (z >>> 5)) + z) ^ k24;
        z -= (((y >>> 5) ^ (y << 4)) + y) ^ k23;
        y -= (((z << 4) ^ (z >>> 5)) + z) ^ k22;
        z -= (((y >>> 5) ^ (y << 4)) + y) ^ k21;
        y -= (((z << 4) ^ (z >>> 5)) + z) ^ k20;
        z -= (((y >>> 5) ^ (y << 4)) + y) ^ k19;
        y -= (((z << 4) ^ (z >>> 5)) + z) ^ k18;
        z -= (((y >>> 5) ^ (y << 4)) + y) ^ k17;
        y -= (((z << 4) ^ (z >>> 5)) + z) ^ k16;
        z -= (((y >>> 5) ^ (y << 4)) + y) ^ k15;
        y -= (((z << 4) ^ (z >>> 5)) + z) ^ k14;
        z -= (((y >>> 5) ^ (y << 4)) + y) ^ k13;
        y -= (((z << 4) ^ (z >>> 5)) + z) ^ k12;
        z -= (((y >>> 5) ^ (y << 4)) + y) ^ k11;
        y -= (((z << 4) ^ (z >>> 5)) + z) ^ k10;
        z -= (((y >>> 5) ^ (y << 4)) + y) ^ k9;
        y -= (((z << 4) ^ (z >>> 5)) + z) ^ k8;
        z -= (((y >>> 5) ^ (y << 4)) + y) ^ k7;
        y -= (((z << 4) ^ (z >>> 5)) + z) ^ k6;
        z -= (((y >>> 5) ^ (y << 4)) + y) ^ k5;
        y -= (((z << 4) ^ (z >>> 5)) + z) ^ k4;
        z -= (((y >>> 5) ^ (y << 4)) + y) ^ k3;
        y -= (((z << 4) ^ (z >>> 5)) + z) ^ k2;
        z -= (((y >>> 5) ^ (y << 4)) + y) ^ k1;
        y -= (((z << 4) ^ (z >>> 5)) + z) ^ k0;
        out[off] = (byte) (y >> 24);
        out[off + 1] = (byte) (y >> 16);
        out[off + 2] = (byte) (y >> 8);
        out[off + 3] = (byte) y;
        out[off + 4] = (byte) (z >> 24);
        out[off + 5] = (byte) (z >> 16);
        out[off + 6] = (byte) (z >> 8);
        out[off + 7] = (byte) z;
        return out;
    }
}
