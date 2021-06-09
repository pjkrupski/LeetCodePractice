# Anything is possible
"""
# Functional solution
def is_sum_equal(first_word, second_word, target_word):
    i = "099"
    convert_words("f")
    print(strip_leading_zeros(i))


def add_words(first_word, second_word):
    return first_word, second_word


def convert_words(word):
    print("hello")
    return word


def strip_leading_zeros(word):
    if word[0] == 0:
        word = word[1:len(word)]
    return word

# Main

is_sum_equal("d", "d", "dd")
"""


class Solution(object):

    def is_sum_equal(self, first_word, second_word, target_word):

        if self.convert_words(self, first_word) \
                + self.convert_words(self, second_word) \
                == self.convert_words(self, target_word):
            return True
        else:
            return False

    # Returns integer value of words
    @staticmethod
    def convert_words(self, word):
        word_map = {'a': 0, 'b': 1, 'c': 2, 'd': 3, 'e': 4, 'f': 5,
                    'g': 6, 'h': 7, 'i': 8, 'j': 9}
        num = ''
        # Strip 0s
        if word[0] is 'a':
            word = word[1:len(word)]
        # Build string of ints
        for i in range(len(word)):
            print(word_map.get(word[i]), " is whats joined on ", i)
            num += str(word_map.get(word[i]))
        # Convert to one number before returning
        #print(num, " is num")
        return int(num)


print(Solution().is_sum_equal("bcd", "bcd", "ceg"))
