# SecureFileEncryption

## 🔒 Secure File Encryption using Java (AES-256, HMAC, and Password Hashing)

**SecureFileEncryption** is a Java-based project that provides file encryption, decryption, password hashing, and HMAC integrity verification using strong cryptographic techniques. It is built using open-source tools and follows best security practices.

---
## ✨ Features
- **AES-256 Encryption**: Encrypt files securely using AES-256.
- **AES-256 Decryption**: Decrypt encrypted files back to their original state.
- **Password Hashing**: Securely hash and verify passwords using **BCrypt**.
- **HMAC Verification**: Generate and verify HMAC to ensure data integrity.
- **Key Management**: Generate and handle encryption keys securely.

---
## 🛠️ Technologies Used
- **Java 11 (JDK 11 LTS)**
- **Maven (Dependency Management)**
- **Bouncy Castle (Encryption Library)**
- **Apache Commons Codec (Hashing Support)**
- **BCrypt (Password Hashing)**

---
## 📥 Installation & Setup

### 1️⃣ Prerequisites
Ensure you have the following installed:
- **JDK 11+** ([Download](https://adoptium.net/))
- **Maven** ([Download](https://maven.apache.org/download.cgi))
- **IntelliJ IDEA / Eclipse** (Optional, for development)

### 2️⃣ Clone the Repository
```sh
 git clone https://github.com/Mahith0534/CryptoCrate.git
 cd SecureFileEncryption
```

### 3️⃣ Build the Project
```sh
mvn clean install
```

---
## 🚀 Usage
### 🔹 Encrypt a File
```java
SecretKey key = FileEncryptor.generateKey();
FileEncryptor.encryptFile("input.txt", "encrypted.dat", key);
```
### 🔹 Decrypt a File
```java
FileDecryptor.decryptFile("encrypted.dat", "decrypted.txt", key);
```
### 🔹 Hash a Password
```java
String hashedPassword = PasswordHasher.hashPassword("mypassword");
```
### 🔹 Verify HMAC Integrity
```java
String hmac = HMACVerifier.generateHMAC("SensitiveData", "SecretKey");
```

---
## 📜 Project Structure
```
SecureFileEncryption/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── encryption/
│   │   │   │   ├── FileEncryptor.java
│   │   │   │   ├── FileDecryptor.java
│   │   │   │   ├── PasswordHasher.java
│   │   │   │   ├── HMACVerifier.java
│   │   │   │   ├── KeyGenerator.java
├── pom.xml
```

---
## ⚡ Dependencies
```xml
<dependencies>
    <!-- Bouncy Castle for Encryption -->
    <dependency>
        <groupId>org.bouncycastle</groupId>
        <artifactId>bcprov-jdk15on</artifactId>
        <version>1.70</version>
    </dependency>

    <!-- Apache Commons Codec for Hashing -->
    <dependency>
        <groupId>commons-codec</groupId>
        <artifactId>commons-codec</artifactId>
        <version>1.15</version>
    </dependency>

    <!-- BCrypt for Secure Password Hashing -->
    <dependency>
        <groupId>org.mindrot</groupId>
        <artifactId>jbcrypt</artifactId>
        <version>0.4</version>
    </dependency>
</dependencies>
```
---
## 🤝 Contributing
Feel free to submit issues and pull requests!

---
## 📧 Contact
For any inquiries, reach out at **venkatamahith@gmail.com** or visit **https://github.com/Mahith0534/CryptoCrate.git**.

