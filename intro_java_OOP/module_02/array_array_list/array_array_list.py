class ArrayAndArrayList:

    def __init__(self, array):
        self.array = array

    def how_many(self, num):
        """Find the count of the given element in the given array"""

        count = 0
        for i in self.array:
            if i == num:
                count += 1

        return count

    def find_max(self):
        """Find the max of a given array"""

        return max(self.array) if len(self.array) > 0 else -1

    
    def max_array(self):
        """Return a list of every occurence of the max number"""

        return [i for i in self.array if i == max(self.array)]

    
    def swap_zero(self):
        '''
        Puts all of the zeros in the given array at the end of the given array.
        Maintains the order of the non-zeros.
        '''

        zero_count = self.array.count(0)
        new_list = [i for i in self.array if i != 0]
        
        n = 0
        while n <= zero_count:
            new_list.append(0)
            n += 1
        
        return new_list
