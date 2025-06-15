# Installing Adoptium Temurin JDK

## 1. Download Temurin JDK

- Visit the [Adoptium Downloads page](https://adoptium.net/).
- Select your operating system (Windows, macOS, or Linux).
- Choose the latest LTS version (e.g., Java 17 or Java 21).
- Click **Download** to get the installer or archive.

## 2. Install the JDK

### Windows

- Run the downloaded `.msi` installer and follow the prompts.
- Optionally, select "Set JAVA_HOME variable" during installation.

### macOS

- Open the `.pkg` installer and follow the instructions.

### Linux

- Extract the downloaded `.tar.gz` archive:
    ```sh
    tar -xzf OpenJDK*.tar.gz
    sudo mv jdk-* /opt/temurin
    ```
- Optionally, add to your PATH and set `JAVA_HOME`:
    ```sh
    export JAVA_HOME=/opt/temurin
    export PATH=$JAVA_HOME/bin:$PATH
    ```

## 3. Verify Installation

Open a terminal or command prompt and run:

```sh
java -version
```

Expected output (example):

```
openjdk version "17.0.10" 2024-01-16
OpenJDK Runtime Environment Temurin-17.0.10+7 (build 17.0.10+7)
OpenJDK 64-Bit Server VM Temurin-17.0.10+7 (build 17.0.10+7, mixed mode)
```

Check the compiler version:

```sh
javac -version
```

## 4. Set JAVA_HOME (Optional)

- **Windows:**  
    Set `JAVA_HOME` in System Properties → Environment Variables.
- **macOS/Linux:**  
    Add to your shell profile (e.g., `.bashrc` or `.zshrc`):
    ```sh
    export JAVA_HOME=/path/to/temurin
    export PATH=$JAVA_HOME/bin:$PATH
    ```

---

You are now ready to use Java!