my_dictionary = {
    'A':'9', 'B':'3', 'C':'#', 'D':'M', 'E':'C', 'F':'P', 'G':'W', 'H':'8', 'I':'2', 'J':'*', 'K':'S', 'L':'I', 'M':'V', 'N':'Z', 'O':'7', 'P':'1', 'Q':'?', 'R':'B', 'S':'O', 'T':'Y', 'U':'F', 'V':'6', 'W':'0', 'X':'!', 'Y':'H', 'Z':'U', '!':'E', '?':'L', '*':'5', '#':'8', '$':'A', '%':'N', '0':'D', '1':'K', '2':'R', '3':'4', '4':'$', '5':'G', '6':'T', '7':'J', '8':'Q', '9':'X'
}
user_input = input("Please enter a phrase or group of numbers with at least 10 characters and no spaces: ")
if len(user_input) < 10:
    print("Invalid input!")
    exit()
output = ""
for character in user_input:
    if character in my_dictionary:
        output += my_dictionary[character]
print(output)