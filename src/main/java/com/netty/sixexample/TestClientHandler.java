package com.netty.sixexample;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Random;

public class TestClientHandler extends SimpleChannelInboundHandler<MyDataInfo.Person> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyDataInfo.Person msg) throws Exception {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        int random = new Random().nextInt(3);
        MyDataInfo.MyMessage myMessage = null;
        if (random == 0) {
            myMessage = MyDataInfo.MyMessage.newBuilder()
                    .setDataType(MyDataInfo.MyMessage.DataType.PersonType)
                    .setPerson(MyDataInfo.Person.newBuilder()
                            .setName("张三").setAge(30)
                            .setAddress("北京").build())
                    .build();
        } else if (random == 1) {
            myMessage = MyDataInfo.MyMessage.newBuilder()
                    .setDataType(MyDataInfo.MyMessage.DataType.DogType)
                    .setDog(MyDataInfo.Dog.newBuilder()
                            .setName("一只狗").setAge(3).build())
                    .build();
        } else if (random == 2) {
            myMessage = MyDataInfo.MyMessage.newBuilder()
                    .setDataType(MyDataInfo.MyMessage.DataType.CatType)
                    .setCat(MyDataInfo.Cat.newBuilder()
                            .setName("一只猫").setCity("上海").build())
                    .build();
        }

        ctx.channel().writeAndFlush(myMessage);
    }
}
