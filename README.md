# Piano-Trainer-App
*An app to easily record and playback piano notes*

## Features
> ## Edit Mode:
- Allows the user to input keys into “frames.”
- When combinations of keys are inputted into a frame, its equivalent note will be written into a music sheet. The app will also show which fingers will be used to play the note.
- Lastly, the user can title the song and save.

> ## Play Mode:
- Allows user to import a song from save files
- Auto play; you can set the speed of each frame – the better the user gets, the faster they’ll set it to.


Progress:
- [x] Dump all views necessary into the .xml file
- [x] A system to toggle between 'edit mode' and 'play mode'
- [x] A way for the user to toggle white and black keys
- [x] Allow the user to select playback speed
- [x] A frame system that remembers what keys were toggled at what frame
- [x] A play button to cycle between all the frames the user wrote to (at the rate set by user)
- [ ] 'PlayKeys(int currentFrame)' needs to play .mp3 files or .wav files
- [ ] Allow the user to save the song into a .json file
- [ ] Allow the user to import a song previously written
- [ ] \(Optional) 'PlayKeys(int currentFrame)' also displays equivalent note played