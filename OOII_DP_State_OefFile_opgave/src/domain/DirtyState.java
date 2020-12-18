package domain;

import java.io.File;

class DirtyState extends FileState {

	public DirtyState(FileEditor fileEditor) {
		super(fileEditor);
	}

	public boolean save() {
		@SuppressWarnings("unused")
		File file = fileEditor.getFile();
		// Save the file
		
		fileEditor.toState(new CleanState(fileEditor));
		return true;
	}
}
