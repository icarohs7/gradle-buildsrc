from os import system
from datetime import datetime

system("git add --all")
dt = datetime.today()
d = f"{dt.day:02}/{dt.month:02}/{dt.year:04}"
t = f"{dt.hour:02}:{dt.minute:02}"

system(f"git commit -m \"auto commit push on {d} {t}\"")
system("git push origin master")
print("\ndone\n")
system("pause")
