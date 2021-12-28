import os


# Filepath to main project folder
main = r'/home/jangboolee/Documents/python_projects/intro_python_java' \
       r'/intro_java_OOP/module_04'


class MyFileReader:

    def __init__(self, filename):
        self.filename = filename

    
    def get_clean_content(self):
        """Read the text line by line and clean the contents of each line"""

        with open(os.path.join(main, 'files', self.filename), 'r') as f:
            return [line.strip() for line in f.readlines() 
                    if len(line.strip()) > 0]


class WordCounter:

    def __init__(self, lines):
        self.lines = lines

    
    def generate_word_counts(self):
        """Calculate the count of each word in the list of lines"""

        word_count = {}
        for line in self.lines:
            for word in line.split():
                if word not in word_count.keys():
                    word_count[word] = 1
                else:
                    word_count[word] += 1
        
        return word_count


    def get_word_counter(self):
        """Return the dictionary word_count"""

        return self.generate_word_counts()


    def get_word_occuring_more_than(self, threshold):
        """Get a list of words that appear more than a given threshold"""

        return [word for word, count in self.get_word_counter().items() 
                if count > threshold]


class MyFileWriter:

    def __init__(self, filename):
        self.filename = filename
    

    def write_to_file(self, words):
        """Write each word in the given list of words to the file"""

        with open(os.path.join(main, 'files', self.filename), 'w') as f:
            for word in words:
                f.write(str(word) + '\n')
        
        print('Results written to file')


if __name__ == "__main__":
    
    # Instantiate file reader class and clean file contents 
    reader = MyFileReader('war_and_peace.txt')
    content = reader.get_clean_content()

    # Instantiate word counter class and find words that occurred more than 5000 times
    counter = WordCounter(content)
    word_count = counter.get_word_counter()
    words = counter.get_word_occuring_more_than(5000)
    
    # Write results to output.txt
    writer = MyFileWriter('output.txt')
    writer.write_to_file(words)
