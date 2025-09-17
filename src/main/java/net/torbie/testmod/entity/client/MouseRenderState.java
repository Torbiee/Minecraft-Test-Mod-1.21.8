package net.torbie.testmod.entity.client;

import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import software.bernie.geckolib.renderer.base.GeoRenderState;
import java.util.Map;
import it.unimi.dsi.fastutil.objects.Reference2ObjectOpenHashMap;
import software.bernie.geckolib.constant.dataticket.DataTicket;
import org.jetbrains.annotations.Nullable;

public class MouseRenderState extends LivingEntityRenderState implements GeoRenderState {
    private final Map<DataTicket<?>, Object> geckoData = new Reference2ObjectOpenHashMap<>();

    @Override
    public <D> void addGeckolibData(DataTicket<D> dataTicket, @Nullable D data) {
        geckoData.put(dataTicket, data);
    }

    @Override
    public boolean hasGeckolibData(DataTicket<?> dataTicket) {
        return geckoData.containsKey(dataTicket);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <D> D getGeckolibData(DataTicket<D> dataTicket) {
        return (D) geckoData.get(dataTicket);
    }

    @Override
    public Map<DataTicket<?>, Object> getDataMap() {
        return geckoData;
    }
}
