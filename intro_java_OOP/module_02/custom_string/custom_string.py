class CustomString:

    def __init__(self, my_string=None, is_set=False):
        """Define class with None and False default values"""
        pass


    def get_string(self):
        """Return the current value of my_string"""
        return self.my_string


    def set_string(self, new_string):
        """Set the value of the current string and set is_set to True"""
        
        if new_string:
            self.my_string = new_string
            self.is_set = True
        else:
            self.is_set = False


    def remove(self, arg):
        '''
        Return a new string where the alphabetical characters in the 
        given arg are removed from the original string
        '''

        # Set of lower-case characters to remove from original string
        to_remove = set(char.lower() for char in arg if char.isalpha())
        
        return ''.join([char for char in self.my_string if char.lower() not in to_remove])


    def reverse(self, arg):
        '''
        Return a new string where the capitalization is reversed for the
        specified characters given in the arg
        '''
        
        # Set of lower-case characters to reverse capitalization
        to_remove = set(char.lower() for char in arg if char.isalpha())

        # Create a string with reversed capitalization for given characters
        reversed_string = ''
        for char in self.my_string:
            if char.lower() in to_remove:
                if char.isupper():
                    reversed_string += char.lower()
                else:
                    reversed_string += char.upper()
            else:
                reversed_string += char

        return reversed_string

    def filter_letters(self, n, more):
        '''
        Return a new string version of the current string where all the letters
        either >= or <= the given char n are removed
        '''

        # Create list version of current string
        current_list = [char for char in self.my_string]

        # Create a filtered version of the current string based on more Boolean
        filtered = []
        if more:
            for char in current_list:
                if char.isalpha():
                    if char.lower() < n.lower():
                        filtered.append(char)
                else:
                    filtered.append(char)
        else:
            for char in current_list:
                if char.isalpha():
                    if char.lower() > n.lower():
                        filtered.append(char)
                else:
                    filtered.append(char)

        return ''.join(filtered)
