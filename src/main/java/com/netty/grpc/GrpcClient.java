package com.netty.grpc;


import com.netty.proto.MyRequest;
import com.netty.proto.MyResponse;
import com.netty.proto.StudentServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {
    public static void main(String[] args) {
        ManagedChannel managedChannel =
                ManagedChannelBuilder.forAddress("localshot", 8899)
                .usePlaintext(true).build();
        StudentServiceGrpc.StudentServiceBlockingStub blockingStub = StudentServiceGrpc
                .newBlockingStub(managedChannel);
        MyResponse myResponse = blockingStub.getRealNameByUsername(MyRequest.newBuilder()
                .setUsername("张三").build());
        System.out.println(myResponse.getRealname());
    }
}
