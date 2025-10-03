# Fragile Block Mod for Minecraft 1.12.2

A Forge mod that adds a "Fragile Block" which has a 5% chance to decay into air with each random tick.

## Features

- **Fragile Block**: A cloth-based block with decay mechanics
  - Material: Cloth (like wool)
  - Hardness: 0.8F
  - Resistance: 4.0F
  - Sound Type: Cloth
  - Creative Tab: Building Blocks
  - Random Tick Updates: Enabled
  - Decay Chance: 5% per random tick

## Building

This mod requires:
- Java 8 (JDK 1.8)
- Forge for Minecraft 1.12.2 (version 14.23.5.2859)
- ForgeGradle 2.3

### Build Instructions

1. Set JAVA_HOME to Java 8:
   ```bash
   export JAVA_HOME=/path/to/jdk1.8
   ```

2. Setup the workspace:
   ```bash
   ./gradlew setupDecompWorkspace
   ```

3. Build the mod:
   ```bash
   ./gradlew build
   ```

The compiled mod JAR will be in `build/libs/`.

## Project Structure

```
src/main/
├── java/com/example/fragileblockmod/
│   ├── FragileBlockMod.java    # Main mod class with @Mod annotation
│   └── FragileBlock.java       # Custom block with decay logic
└── resources/
    ├── mcmod.info              # Mod metadata
    └── assets/fragileblockmod/
        ├── blockstates/
        │   └── fragile_block.json
        ├── models/
        │   ├── block/
        │   │   └── fragile_block.json
        │   └── item/
        │       └── fragile_block.json
        ├── textures/blocks/
        │   └── fragile_block.png
        └── lang/
            └── en_us.lang
```

## How It Works

1. The `FragileBlock` class extends `Block` and sets `setTickRandomly(true)`
2. The `updateTick` method is called randomly by Minecraft
3. Each tick has a 5% chance (0.05 probability) to turn the block into air
4. This only happens on the server side (`!world.isRemote`)

## Installation

1. Build the mod using the instructions above
2. Copy the JAR from `build/libs/` to your Minecraft `mods/` folder
3. Launch Minecraft 1.12.2 with Forge installed
4. Find "Fragile Block" in the Building Blocks creative tab

## License

This mod is provided as an example implementation.
