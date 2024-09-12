package backups.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.Test;

import backups.FileBackup;
import backups.FolderBackup;

class BackupsTest {
	
	FileBackup date = new FileBackup(new byte[] {2, 0, 2, 4, 0, 9, 0, 6});
	FolderBackup math = new FolderBackup(Map.of(
			"primes", new FileBackup(new byte[] {2, 3, 5, 7, 11, 13, 19}),
			"factorials", new FileBackup(new byte[] {2, 6, 24, 120})));

	@Test
	void testFileBackupConstructor() {
		assertArrayEquals(new byte[] {2, 0, 2, 4, 0, 9, 0, 6}, date.getContents());
	}
	
	@Test
	void testFolderBackupConstructor() {
		assertEquals(Map.of(
			"primes", new FileBackup(new byte[] {2, 3, 5, 7, 11, 13, 19}),
			"factorials", new FileBackup(new byte[] {2, 6, 24, 120})), math.getEntries());
	}
	
	@Test
	void testEquals() {
		assertEquals(date, new FileBackup(new byte[] {2, 0, 2, 4, 0, 9, 0, 6}));
		assertNotEquals(date, new FileBackup(new byte[] {2, 0, 2, 4, 0, 9, 1, 2}));
		assertNotEquals(date, math);
		
		assertEquals(math, new FolderBackup(Map.of(
			"primes", new FileBackup(new byte[] {2, 3, 5, 7, 11, 13, 19}),
			"factorials", new FileBackup(new byte[] {2, 6, 24, 120}))));
	    assertNotEquals(math, new FolderBackup(Map.of()));
	    assertNotEquals(math, date);
	}

}
