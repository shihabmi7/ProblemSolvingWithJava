# Problem Solving with Java

A comprehensive Java repository focused on **Problem Solving**, **Object-Oriented Programming (OOP)**, and **Design Pattern Implementation**. This repository contains practical, production-ready code examples.

## 📚 Repository Overview

This is a learning and reference resource for developers looking to understand and apply:
- Gang of Four (GoF) Design Patterns
- Object-Oriented Programming Principles
- Time & Space Complexity Analysis
- Problem-Solving Techniques
- SOLID Principles

---

## 🏗️ Project Structure

```
ProblemSolvingWithJava/
├── src/com/shihab/
│   ├── Main.java                    # Entry point with utility methods
│   ├── patterns/                    # Design Pattern implementations
│   ├── oop/                         # OOP principles examples
│   ├── solid/                       # SOLID Principles implementations
│   ├── complexity/                  # Time & Space Complexity analysis
│   ├── search/                      # Search algorithms
│   ├── codility/                    # Codility problem solutions
│   ├── leetcode/                    # LeetCode problem solutions
│   ├── problem_solving/             # General problem-solving techniques
│   ├── general/                     # General Java utilities
│   └── top/                         # Top problems & algorithms
├── .gitignore                       # Git ignore file for build artifacts
├── README.md                        # This file
└── ...
```

---

## 📖 Repository Contents

### 1️⃣ **Design Patterns** (`patterns/`)

Modern, production-ready design pattern implementations.

#### **Creational Patterns**

##### **Singleton Pattern**

The repository demonstrates 4 different Singleton implementations, with detailed comparisons:

| Implementation | Thread-Safe | Lazy Loading | Performance | Recommendation |
|---|---|---|---|---|
| [**Bill Pugh Singleton**](src/com/shihab/patterns/BillPughSingleton.java) | ✅ Yes | ✅ Yes | ⚡⚡⚡ Excellent | ⭐ **RECOMMENDED** |
| [Eager Singleton](src/com/shihab/patterns/EagerSingleton.java) | ✅ Yes | ❌ No | ⚡ Good | Use if early init needed |
| [Lazy Singleton](src/com/shihab/patterns/LazySingleton.java) | ✅ Yes | ✅ Yes | ⚡⚡ Good | Traditional approach |
| [Static Block Singleton](src/com/shihab/patterns/StaticBlockSingleton.java) | ✅ Yes | ❌ No | ⚡ Good | Alternative |

**Why Bill Pugh Singleton?**
- Uses Java's static inner class loading mechanism
- Provides true lazy initialization without explicit synchronization
- Perfect for production use
- Leverages the **Initialization-on-demand holder idiom**

```java
public class BillPughSingleton {
    private BillPughSingleton() {}
    
    private static class LazyHolder {
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }
    
    public static BillPughSingleton getInstance() {
        return LazyHolder.INSTANCE;
    }
}
```

##### **Factory Pattern**

- [**CarFactory.java**](src/com/shihab/patterns/CarFactory.java) - Simple factory implementation for car object creation
  - Demonstrates object creation without exposing instantiation logic
  - Includes car type enumeration and concrete implementations

##### **Builder Pattern**

- [**User.java**](src/com/shihab/patterns/User.java) - Complete builder pattern implementation
  - Creates immutable objects with fluent interface
  - Provides readability and maintains optional parameters
  - [**UseBuilderPattern.java**](src/com/shihab/patterns/UseBuilderPattern.java) - Usage examples

**Benefits:**
- ✅ Reduced constructor parameters
- ✅ Highly readable method calls
- ✅ No need to pass null for optional parameters
- ✅ Immutable objects

**Usage Example:**
```java
User user = new User.UserBuilder("Shihab", "Uddin")
    .age(32)
    .phone("01700000000")
    .build();
```

**Supporting Classes:**
- [BMW.java](src/com/shihab/patterns/BMW.java)
- [Ferrari.java](src/com/shihab/patterns/Ferrari.java)
- [Car.java](src/com/shihab/patterns/Car.java)
- [CarType.java](src/com/shihab/patterns/CarType.java)
- [TestCarFactoryPattern.java](src/com/shihab/patterns/TestCarFactoryPattern.java)
- [DemoSingleton.java](src/com/shihab/patterns/DemoSingleton.java)

---

### 2️⃣ **Object-Oriented Programming (OOP)** (`oop/`)

Practical demonstrations of OOP principles:

- [**InheritanceTest.java**](src/com/shihab/oop/InheritanceTest.java) - Inheritance pattern demonstration
- [**Parent.java**](src/com/shihab/oop/Parent.java) - Base class example
- [**Child.java**](src/com/shihab/oop/Child.java) - Derived class example

**Concepts Covered:**
- Inheritance
- Method Overriding
- Super keyword usage
- Access modifiers

---

### 3️⃣ **SOLID Principles** (`solid/`)

Comprehensive implementations of all five SOLID principles with practical examples and best practices.

#### **S - Single Responsibility Principle**
- [**S_SingleResponsibility.java**](src/com/shihab/solid/S_SingleResponsibility.java)
  - A class should have only one reason to change
  - Demonstrates separation of concerns
  - Examples of violation and correction

#### **O - Open/Closed Principle**
- [**O_OpenClosed.java**](src/com/shihab/solid/O_OpenClosed.java)
  - Software entities should be open for extension but closed for modification
  - Shows how to use abstraction and polymorphism
  - Enables easy addition of new functionality

#### **L - Liskov Substitution Principle**
- [**L_LiskovSubstitution.java**](src/com/shihab/solid/L_LiskovSubstitution.java)
  - Subtypes must be substitutable for their base types
  - Demonstrates proper inheritance hierarchy
  - Ensures behavioral consistency

#### **I - Interface Segregation Principle**
- [**I_InterfaceSegregation.java**](src/com/shihab/solid/I_InterfaceSegregation.java)
  - Clients should not be forced to depend on interfaces they don't use
  - Shows how to design focused, cohesive interfaces
  - Reduces coupling between components

#### **D - Dependency Inversion Principle**
- [**D_DependencyInversion.java**](src/com/shihab/solid/D_DependencyInversion.java)
  - High-level modules should not depend on low-level modules
  - Both should depend on abstractions
  - Demonstrates dependency injection patterns

#### **Overview & Guide**
- [**SOLIDPrinciplesOverview.java**](src/com/shihab/solid/SOLIDPrinciplesOverview.java)
  - Comprehensive overview of all SOLID principles
  - Real-world examples and use cases
  - Best practices and anti-patterns

---

### 4️⃣ **Algorithms & Problem-Solving**

#### **Search Algorithms** (`search/`)
- [**BinarySearch**](src/com/shihab/search/BinarySearch.java) - Efficient search in sorted arrays

#### **Time & Space Complexity** (`complexity/`)
- Analysis of algorithm performance
- Big-O notation examples

#### **Coding Challenge Platforms**

- **Codility** (`codility/`) - Codility problem solutions
- **LeetCode** (`leetcode/`) - LeetCode problem solutions
- **HackerRank Integration** - Integrated in [Main.java](src/com/shihab/Main.java)

#### **General Problem-Solving** (`problem_solving/`)
- Various algorithmic techniques and solutions

---

## 🎯 Key Features

### ✨ Production-Ready Code
- Well-documented implementations
- Best practices followed
- Thread-safe where required
- Clear, maintainable code

### 📚 Comprehensive Examples
- Multiple implementations for comparison
- Trade-offs explained
- Performance characteristics detailed
- Real-world use cases

### 🔗 Complete Structure
- Factory patterns for object creation
- Singleton patterns for shared resources
- Builder patterns for complex objects
- Inheritance hierarchy demonstrations
- All five SOLID principles implemented

### 🛠️ Build Management
- `.gitignore` configured to exclude:
  - `out/` folder (compiled output)
  - `bin/` folder (build artifacts)
  - `*.class`, `*.jar`, `*.war`, `*.ear` files
  - IDE settings (`.idea/`, `.vscode/`)
  - OS-specific files
  - Build directories

---

## 🚀 Getting Started

### Prerequisites
- Java 8 or higher
- Maven or Gradle (optional)
- Your favorite IDE (IntelliJ, Eclipse, VS Code)

### Clone the Repository
```bash
git clone https://github.com/shihabmi7/ProblemSolvingWithJava.git
cd ProblemSolvingWithJava
```

### Explore the Code
1. Start with [Main.java](src/com/shihab/Main.java) for entry points
2. Navigate to `solid/` for SOLID principles implementations
3. Check `patterns/` for design pattern implementations
4. Review `oop/` for OOP principles
5. Study individual algorithms in their respective folders

### Compile & Run
```bash
# Compile all Java files
javac -d bin src/com/shihab/**/*.java

# Run specific class
java -cp bin com.shihab.patterns.DemoSingleton

# Run SOLID principles overview
java -cp bin com.shihab.solid.SOLIDPrinciplesOverview
```

---

## 💡 Learning Roadmap

### Beginner Level
1. OOP Principles (`oop/`)
2. Factory Pattern (`patterns/CarFactory.java`)
3. Builder Pattern (`patterns/User.java`)

### Intermediate Level
1. All Singleton Implementations (`patterns/*Singleton.java`)
2. Search Algorithms (`search/`)
3. Complexity Analysis (`complexity/`)

### Advanced Level
1. SOLID Principles (`solid/`)
   - Start with [SOLIDPrinciplesOverview.java](src/com/shihab/solid/SOLIDPrinciplesOverview.java)
   - Then explore each principle individually
2. Composite patterns
3. Advanced problem-solving techniques

---

## 📝 Code Quality Standards

This repository follows:
- ✅ Java naming conventions
- ✅ Clear documentation and comments
- ✅ SOLID principles
- ✅ DRY (Don't Repeat Yourself)
- ✅ KISS (Keep It Simple, Stupid)
- ✅ Thread-safety where applicable

---

## 🔧 Technologies & Tools

- **Language**: Java 8+
- **Paradigms**: Object-Oriented, Functional
- **Design Patterns**: Gang of Four
- **Principles**: SOLID
- **Problem Platforms**: LeetCode, HackerRank, Codility
- **Version Control**: Git with `.gitignore` for clean repository

---

## 📊 Repository Statistics

- **Language**: 100% Java
- **Focus Areas**: Design Patterns, OOP, SOLID Principles, Problem Solving
- **Use Case**: Learning, Reference, Production Code

---

## 🤝 Contributing

Contributions are welcome! Please ensure:
- ✅ Code follows Java conventions
- ✅ Each implementation includes clear documentation
- ✅ Examples are practical and well-commented
- ✅ New patterns/principles have comprehensive examples
- ✅ Update README with new additions

---

## 📄 Documentation Standards

Each Java class should include:
```java
/**
 * Brief description of the class
 * 
 * Benefits/Advantages (if applicable):
 * - Point 1
 * - Point 2
 * 
 * Drawbacks/Costs (if applicable):
 * - Point 1
 * - Point 2
 * 
 * Use Cases:
 * - Scenario 1
 * - Scenario 2
 */
```

---

## 📚 References & Further Reading

- **Gang of Four Design Patterns** - Classic reference
- **Effective Java by Joshua Bloch** - Best practices
- **Java Memory Model** - Bill Pugh's contributions
- **SOLID Principles** - Robert C. Martin
- **LeetCode & HackerRank** - Problem-solving platforms

---

## 🎓 Learning Outcomes

After exploring this repository, you will understand:

✅ How to implement Gang of Four design patterns
✅ When and why to use specific patterns
✅ OOP principles and their application
✅ Algorithm complexity analysis
✅ Thread-safe singleton implementations
✅ Fluent interface and builder patterns
✅ Best practices for production code
✅ All five SOLID principles and practical implementations

---

## ⭐ If You Find This Helpful

- 🌟 Star the repository
- 📢 Share with others
- 🐛 Report issues
- 💬 Suggest improvements
- 🤝 Contribute enhancements

---

## 👤 Author

**Shihab Mi**
- GitHub: [@shihabmi7](https://github.com/shihabmi7)
- Repository: [ProblemSolvingWithJava](https://github.com/shihabmi7/ProblemSolvingWithJava)

---

## 📜 License

*(Add your license information here)*

---

## 📞 Support & Questions

For questions or discussions:
- 📧 Open an issue on GitHub
- 💬 Start a discussion
- 🤝 Submit a pull request

---

**Happy Coding & Learning! 🎓**

*Last Updated: 2026*
