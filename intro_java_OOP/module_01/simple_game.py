class simple_game:

    def __init__(self, game_num=0):
        """Define the simple_game class with a default value of game_num = 0"""

        # Ask user for a valid input between 1 and 2
        while True:
            try:
                self.game_num = int(input('Enter 1 for convertTime and 2 for digitsSum: '))
                if self.game_num in range(1,3):
                    break
                else:
                    print('Please enter a value between 1 and 2')
            except ValueError:
                print('Please enter a value between 1 and 2')

        if self.game_num == 1:
            
            # Ask for valid input for convertTime
            while True:
                try:
                    seconds = int(input('Enter an integer of seconds to convert:  '))
                    break
                except ValueError:
                    print('Please enter a valid integer')
            
            # Run convert_time function with input
            self.convert_time(seconds=seconds)
        
        else:
            
            # Ask for valid input for digitsSum
            while True:
                try:
                    num = int(input('Enter an integer to sum digits for: '))
                    break
                except ValueError:
                    print('Enter a valid integer')
            
            # Run digits_sum function with input
            self.digits_sum(num=num)

    
    def convert_time(self, seconds):
        """A method that converts the given seconds to hours:minuts:seconds"""
        
        # For valid inputs
        if seconds > 0:

            # Calculate hours, mins, and seconds based on input
            hours = int(seconds / 3600)
            mins = int((seconds % 3600) / 60)
            secs = int((seconds) - (hours * 3600) - (mins * 60))
        
        # For input of 0
        elif seconds == 0:
            hours, mins, secs = 0, 0, 0

        # For invalid inputs
        else:
            hours, mins, secs = -1, -1, -1
        
        result = f'{str(hours)}:{str(mins)}:{str(secs)}'
        print(result)
        return result
        

    def digits_sum(self, num):
        """A method that adds all the digits in the given non-negative integer"""
        
        digits_sum = sum([int(char) for char in str(num)])
        
        print(digits_sum)
        return digits_sum


if __name__ == "__main__":
    
    results = simple_game()
