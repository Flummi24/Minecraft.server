package net.minecraft.util.parsing.packrat.commands;

import com.mojang.brigadier.StringReader;
import java.util.stream.Stream;
import net.minecraft.resources.MinecraftKey;
import net.minecraft.util.parsing.packrat.ParseState;
import net.minecraft.util.parsing.packrat.SuggestionSupplier;

public interface ResourceSuggestion extends SuggestionSupplier<StringReader> {

    Stream<MinecraftKey> possibleResources();

    @Override
    default Stream<String> possibleValues(ParseState<StringReader> parsestate) {
        return this.possibleResources().map(MinecraftKey::toString);
    }
}