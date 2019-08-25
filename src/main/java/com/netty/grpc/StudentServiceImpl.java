package com.netty.grpc;

import com.netty.proto.MyRequest;
import com.netty.proto.MyResponse;
import com.netty.proto.StudentServiceGrpc;
import io.grpc.stub.StreamObserver;

public class StudentServiceImpl extends StudentServiceGrpc.StudentServiceImplBase {
    @Override
    public void getRealNameByUsername(MyRequest request, StreamObserver<MyResponse> responseObserver) {
        System.out.println("接收到来自客户端的消息： " + request.getUsername());
        responseObserver.onCompleted();
    }
}
