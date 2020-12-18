package domain;

import java.io.File;

class CleanState extends FileState {

	public CleanState(FileEditor fileEditor) {
		super(fileEditor);
	}

	public boolean edit() {
		@SuppressWarnings("unused")
		File file = fileEditor.getFile();
		// Edit the file
		
		fileEditor.toState(new DirtyState(fileEditor));
		return true;
	}
}
