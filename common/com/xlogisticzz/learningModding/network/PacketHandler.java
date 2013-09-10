package com.xlogisticzz.learningModding.network;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;
import com.xlogisticzz.learningModding.entities.EntitySpaceship;
import com.xlogisticzz.learningModding.lib.Constants;

import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;

/**
 * Learning Modding Mod
 * 
 * @author xLoGisTicZz.
 * 
 *         Some code may be from tutorials.
 * 
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class PacketHandler implements IPacketHandler {
    
    @Override
    public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player) {
    
        ByteArrayDataInput reader = ByteStreams.newDataInput(packet.data);
        EntityPlayer entityPlayer = (EntityPlayer) player;
        
        /* ID for the packet */
        int packetId = reader.readByte();
        
        /* Code based upon ID for the packet */
        switch (packetId) {
        /* Spaceship Bomb packet */
            case 0 :
                int entityId = reader.readInt();
                Entity entity = entityPlayer.worldObj.getEntityByID(entityId);
                if (entity != null && entity instanceof EntitySpaceship && entity.riddenByEntity == entityPlayer){
                    ((EntitySpaceship) entity).dropBomb();
                }
                break;
        }
        
    }
    
    /* Spaceship Bomb packet */
    public static void sendShipBombPacket(EntitySpaceship entity) {
    
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        DataOutputStream dataStream = new DataOutputStream(byteStream);
        
        try{
            dataStream.writeByte(0);
            dataStream.writeInt(entity.entityId);
            
            PacketDispatcher.sendPacketToServer(PacketDispatcher.getPacket(Constants.Mod.MODID, byteStream.toByteArray()));
        }catch (IOException e){
            System.err.append("Failled to send spaceship drop packet");
        }
    }
}
