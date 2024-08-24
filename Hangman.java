import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class Hangman {
    private static final int MAX_ATTEMPTS = 6; // Максимальное количество попыток
    private static String randomWord;       // Список слов
    private static String filePath = "src/resources/RandomWords.txt"; //Путь

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Добро пожаловать в игру 'Виселица'");
        while (true) {
            System.out.println("Нажми '1', чтобы начать новую игру");
            System.out.println("Нажми '2', чтобы выйти из приложения");
            String choice = scanner.nextLine(); //Выбор пользователя

            if (choice.equals("1")) {
                startGame(scanner); //1 - игра запускается
            } else if (choice.equals("2")) {
                System.out.println("Выход из приложения..."); // 2 - выход
                break; // Выход из цикла
            } else {
                System.out.println("Неверный выбор, попробуйте снова."); // Сообщаем об ошибке ввода
            }
        }
        scanner.close(); // Закрываем сканер
    }

    private static void startGame(Scanner scanner) {
        String wordToGuess = GetGenerateRandomWord(); // Получаем случайное слово из списка
        StringBuilder currentGuess = new StringBuilder("*".repeat(wordToGuess.length())); // Инициализируем строку угаданных букв
        ArrayList<Character> guessedLetters = new ArrayList<>(); // Список угаданных букв
        int attempts = 0; // Счётчик ошибок

        while (attempts < MAX_ATTEMPTS && currentGuess.indexOf("*") != -1) {
            System.out.println("Слово: " + currentGuess); // Показываем текущее состояние слова
            printHangman(attempts); // Отображаем текущее состояние виселицы
            System.out.print("Угадайте букву: ");
            char guess = scanner.nextLine().charAt(0); // Читаем букву от пользователя

            if (guessedLetters.contains(guess)) {
                System.out.println("Вы уже угадывали эту букву. Попробуйте другую."); // Проверяем уже угаданные буквы
                continue;
            }

            guessedLetters.add(guess); // Добавляем букву в список угаданных

            // Обновляем текущее состояние слова
            if (wordToGuess.indexOf(guess) != -1) {
                for (int i = 0; i < wordToGuess.length(); i++) {
                    if (wordToGuess.charAt(i) == guess) {
                        currentGuess.setCharAt(i, guess); // Заменяем "*" на угаданную букву
                    }
                }
            } else {
                attempts++; // Увеличиваем счётчик попыток при неверном ответе
            }
        }

        // Проверяем результат игры
        if (currentGuess.indexOf("*") == -1) {
            System.out.println("Поздравляем! Вы угадали слово: " + wordToGuess); // Угадали слово
        } else {
            System.out.println("Вы проиграли. Загаданное слово: " + wordToGuess); // Проиграли
        }
    }
    
    private static void printHangman(int attempts) {
        // Отображение виселицы в зависимости от количества попыток
        switch (attempts) {
            case 0:
                System.out.println("  _____");
                System.out.println(" |     |");
                System.out.println(" |");
                System.out.println(" |");
                System.out.println(" |");
                System.out.println(" |");
                System.out.println(" |___");
                break;
            case 1:
                System.out.println("  _____");
                System.out.println(" |     |");
                System.out.println(" |     O");
                System.out.println(" |");
                System.out.println(" |");
                System.out.println(" |");
                System.out.println(" |___");
                break;
            case 2:
                System.out.println("  _____");
                System.out.println(" |     |");
                System.out.println(" |     O");
                System.out.println(" |     |");
                System.out.println(" |");
                System.out.println(" |");
                System.out.println(" |___");
                break;
            case 3:
                System.out.println("  _____");
                System.out.println(" |     |");
                System.out.println(" |     O");
                System.out.println(" |    /|");
                System.out.println(" |");
                System.out.println(" |");
                System.out.println(" |___");
                break;
            case 4:
                System.out.println("  _____");
                System.out.println(" |     |");
                System.out.println(" |     O");
                System.out.println(" |    /|\\");
                System.out.println(" |");
                System.out.println(" |");
                System.out.println(" |___");
                break;
            case 5:
                System.out.println("  _____");
                System.out.println(" |     |");
                System.out.println(" |     O");
                System.out.println(" |    /|\\");
                System.out.println(" |    /");
                System.out.println(" |");
                System.out.println(" |___");
                break;
            case 6:
                System.out.println("  _____");
                System.out.println(" |     |");
                System.out.println(" |     O");
                System.out.println(" |    /|\\");
                System.out.println(" |    / \\");
                System.out.println(" |");
                System.out.println(" |___");
                break;
        }
    }
    public static String GetGenerateRandomWord() {          //генерация случайного слова
        ArrayList<String> words = new ArrayList<>();
        Random random = new Random();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    words.add(line.trim());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        randomWord = words.get(random.nextInt(words.size()));
        return randomWord;
    }
}
