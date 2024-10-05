### Folder structure (Maven-like)
```
├── README.md
├── bin
├── docs
│    ├── FolderStructure.md
│    └── Git.md
└── src
    ├── main
    │   ├── java
    │   │    ├── boundary
    │   │    ├── control
    │   │    ├── entity
    │   │    └── gui
    │   │        └── LoginGUI.java
    │   └── resources
    └── test
        ├── java
        └── resources
```
The structure that follow "best practice" is split in `src/` folder, which contains the `main` source code and the `test` source code.
The compiled code will be put into `bin/` folder.

The `java/` folder contains all the classes for BCE and the GUI. The `resources/` will contains some required configs file or text file.