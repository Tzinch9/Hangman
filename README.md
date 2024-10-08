# Виселица
Классическая игра в слова, реализованная на языке Java, в консольном интерфейсе. 

Словарь загаданных слов находится в src/resources/RandomWords.txt.

Техническое задание проекта:
https://zhukovsd.github.io/java-backend-learning-course/projects/hangman/
# Принцип игры
Один из игроков загадывает слово — пишет на бумаге любые две буквы слова и отмечает места для остальных букв, например чертами (существует также вариант, когда изначально все буквы слова неизвестны). Также рисуется виселица с петлёй.

Согласно традиции русских лингвистических игр, слово должно быть именем существительным, нарицательным в именительном падеже единственного числа, либо множественного числа при отсутствии у слова формы единственного числа.

Второй игрок предлагает букву, которая может входить в это слово. Если такая буква есть в слове, то первый игрок пишет её над соответствующими этой букве чертами — столько раз, сколько она встречается в слове. Если такой буквы нет, то к виселице добавляется круг в петле, изображающий голову. Второй игрок продолжает отгадывать буквы до тех пор, пока не отгадает всё слово. За каждый неправильный ответ первый игрок добавляет одну часть туловища к виселице (обычно их 6: голова, туловище, 2 руки и 2 ноги, существует также вариант с 8 частями — добавляются ступни, а также самый длинный вариант, когда сначала за неотгаданную букву рисуются части самой виселицы).

Если туловище в виселице нарисовано полностью, то отгадывающий игрок проигрывает, считается повешенным. Если игроку удаётся угадать слово, он выигрывает и может загадывать слово. 
# Инструкция

При запуске программы, Вам будет предложено два варианта событий:

    1 - Начать игру
    2 - Закрыть игру

После того как игра запустилась, будет сгенерировано слово, которое игроку, следует угадать. Подсказки отсутствуют. Только Вы, и ваша удача! Если буква, будет совпадать, с вашим выбором, она будет добавлена, на свое место. У Вас будет, лишь 6 попыток, чтобы дойти до финиша, и отгадать слово. Необходимо вводить буквы в нижнем регистре.


![image](https://github.com/user-attachments/assets/ce1b16a3-a863-42e3-8d1e-e785693976f9)




