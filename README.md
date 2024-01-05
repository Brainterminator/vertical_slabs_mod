
# Vertical Slabs Mod

This mod is supposed to load all existing slab blocks and generate a vertical slab version of them.


## Installation

You can download the mod file [here](https://github.com/Brainterminator/vertical_slabs_mod/releases/download/0.1.0/verticalslabs-0.1.0.jar)

## Deployment

To setup the project in gradle make sure to run the runData task first. Due to the way the blockstate and model files are generated it is required to run the runClient task two times. At the first time you need to uncomment the line:

BlockStateAndModelGenerator.registerBlockStatesAndModels();

in the VerticalSlabs class. This will ensure all the files are generated on the first run. Turn it back to commented to speed up the client startup process. The file generation has only been tested in a default IntelliJ environment, paths might need to be adjusted  to work in other environments.


## Authors

- [@Brainterminator](https://github.com/Brainterminator)

