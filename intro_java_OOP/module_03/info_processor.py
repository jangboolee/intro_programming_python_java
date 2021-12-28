import os

# Filepath to main project folder
main = r'/home/jangboolee/Documents/python_projects/intro_python_java' \
       r'/intro_java_OOP/module_03/'


class MyFileReader:

    def __init__(self, filename):
        self.filename = filename
        

    def get_clean_content(self):
        """Get cleaned up lines of text as a list"""

        with open(os.path.join(main, 'files', self.filename), 'r') as f:
            return [line.strip() for line in f.readlines() 
                    if len(line.strip()) > 0]


class InfoProcessor:

    def __init__(self, lines):
        self.lines = lines

    
    def get_next_string_starts_with(self, string):
        """Helper method to retrieve next item from designated string"""
        
        lines = self.lines
        if string in lines:
            for i, item in enumerate(lines):
                if item == string:
                    return lines[i+1] 


    def get_course_name(self):
        """Method to retrieve course name from read information"""

        return self.get_next_string_starts_with('Course:')


    def get_course_id(self):
        """Method to retrieve course ID from read information"""

        return int(self.get_next_string_starts_with('CourseID:'))

    
    def get_student_id(self):
        """Method to retrieve student ID from read information"""

        return int(self.get_next_string_starts_with('StudentID:'))


class MyFileWriter:

    def __init__(self, filename):
        self.filename = filename


    def write_to_file(self, words):
        """Method to write contents to a TXT file"""

        with open(os.path.join(main, 'files', self.filename), 'w') as f:
            for word in words:
                f.write(str(word) + '\n')


if __name__ == "__main__":

    # Instantiate file reader class and get cleaned contents of the file
    reader = MyFileReader('info.txt')
    contents = reader.get_clean_content()
    
    # Instantiate info processor class and parse info
    processor = InfoProcessor(contents)
    to_write = [processor.get_course_name(), processor.get_course_id(),
                processor.get_student_id()]
    
    # Instantiate file writer class
    writer = MyFileWriter('personal_info.txt')
    
    # Ask for user input and write contents to new file
    option = input("Do you want to add your personal information? (Y/N) ")
    if option.lower() == 'n':
        writer.write_to_file(to_write)
        print("Thank you, the course information has been exported to a file")
    else:
        to_write.append(input("Please input your name: "))
        to_write.append(input("Please input your favorite color: "))
        to_write.append(input("Please input your favorite number: "))
        writer.write_to_file(to_write)
        print("Thank you, the course information and personal information has been exported to a file")
