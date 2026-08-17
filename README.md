# Rougher Environment
## Forked from [Jaredlll08](https://modrinth.com/user/jaredlll08)'s **[Ambient Environment](https://modrinth.com/mod/ambient-environment)**

Applies a noise gradient to places where it probably shouldn't be in to break up repeated surfaces.

Uses the core logic from [Ambient Environment](https://modrinth.com/mod/ambient-environment) but applies it to more places.
<br />

* Leaves and Dry leaves can now have a slight yellow-er tint.
<br />
* Sand is slightly darker in some spots, which makes deserts look like they have waves in flatter places.
<br />
* Lava has dark spots, similar to how it looks in some shaders.
<br />

All of this was done by modifying the base methods used in [Ambient Environment](https://modrinth.com/mod/ambient-environment), 
however, since Ambient Environment uses biome blend and biome blend only extends to 
grass, leaves and water, and not sand or lava.
<br />

I had to modify their textures to allow for them to receive tint 
(as a side effect their colors are slightly off from vanilla, 
most noticeable in lava where I barely tried to give it vanilla tint), 
this means that this mod won't work with texture packs that change those two, 
if you want it to work you would need to modify the pack to have its respective textures be monochrome, 
and add a block model for sand, the .json would look something like this:
```
{
  "parent": "minecraft:block/leaves",
  "textures": {
    "all": "minecraft:block/sand"
  }
}
```
Notice how we use the `"minecraft:block/leaves"` parent, this is to let the sand be fully colored on all sides.
<br />
There's also a fake blend effect applied to the non biome blend noises, 
I would like to state that the way this is done sucks and is definitely not optimal
however this was meant to be a weekend project and I don't want to read anymore wikis.
<br />

Also I barely know any java and have no idea as to how this even works so please forgive me.
<br />

Didnt use AI tho so we good ig.