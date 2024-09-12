package backups;

import java.util.Arrays;

/**
 * @immutable
 */
public class FileBackup extends Backup {
	
	/**
	 * @invar | contents != null
	 * 
	 * @representationObject
	 */
	private byte[] contents;
	
	/**
	 * @post | result != null
	 * 
	 * @creates | result
	 */
	public byte[] getContents() { return contents.clone(); }
	
	/**
	 * @pre | contents != null
	 * 
	 * @inspects | contents
	 * 
	 * @post | Arrays.equals(getContents(), contents)
	 */
	public FileBackup(byte[] contents) {
		this.contents = contents.clone();
	}
	
	@Override
	public boolean equals(Object object) {
		return object instanceof FileBackup b && Arrays.equals(contents, b.contents);
	}
	
	@Override
	public int hashCode() {
		return Arrays.hashCode(contents);
	}

}
