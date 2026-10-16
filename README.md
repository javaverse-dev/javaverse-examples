# Javaverse Demonstrations

Where Java Developers grow.

This project is a collection of small and focused tutorials - each covering a single and well-defined area of development in the Java ecosystem. A strong focus of these is, of course, Quarkus, AI, Spring Framework, Langchain4j, etc.

## Projects

### langchain4j-decision

A demonstration of using LangChain4j's type-safe decision-making capabilities to analyze the intent of messages.

#### Features
- **Intent Analysis**: Uses a type-safe AI service to categorize YouTube comments into specific intents (e.g., QUESTION, PRAISE, CRITICISM, SPAM).
- **CSV Integration**: Reads sample comments from a CSV file for analysis.
- **Type-Safe AI**: Leverages `TypeSafeDecisionModel` and `@Decide` annotations for structured output.

#### Prerequisites
- Java 27
- Maven
- A TypeSafe API Key (`TYPESAFE_API_KEY` environment variable)

#### Getting Started
1. Clone the repository.
2. Set your API key:
   ```bash
   export TYPESAFE_API_KEY=your_api_key_here
   ```
3. Build the project:
   ```bash
   mvn clean package
   ```
4. Run the application:
   ```bash
   java -jar langchain4j-decision/target/langchain4j-decision-1.0.0.jar
   ```

## License
Refer to the LICENSE file for more details.
