package backups;

import java.util.Map;

/**
 * @immutable
 * 
 * @invar | getEntries().entrySet().stream().allMatch(e -> e.getKey() != null && e.getValue() != null)
 */
public class FolderBackup extends Backup {
	
	/**
	 * @invar | entries != null
	 * @invar | entries.entrySet().stream().allMatch(e -> e.getKey() != null && e.getValue() != null)
	 * 
	 * @representationObject
	 */
	private Map<String, Backup> entries;
	
	/**
	 * @post | result != null
	 * 
	 * @creates | result
	 */
	public Map<String, Backup> getEntries() { return Map.copyOf(entries); }
	
	/**
	 * @pre | entries != null
	 * @pre | entries.entrySet().stream().allMatch(e -> e.getKey() != null && e.getValue() != null)
	 * 
	 * @inspects | entries
	 * 
	 * @post | getEntries().equals(entries)
	 */
	public FolderBackup(Map<String, Backup> entries) {
		this.entries = Map.copyOf(entries);
	}
	
	@Override
	public boolean equals(Object object) {
		return object instanceof FolderBackup b && entries.equals(b.entries);
	}
	
	@Override
	public int hashCode() {
		return entries.hashCode();
	}

}
