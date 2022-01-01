import {
  OnGatewayConnection,
  OnGatewayDisconnect,
  OnGatewayInit,
  SubscribeMessage,
  WebSocketGateway,
  WebSocketServer,
} from '@nestjs/websockets';
import { Server, Socket } from 'socket.io';
import { Message } from './message';
import { AppService } from './app.service';

@WebSocketGateway(3002)
export class AppGateway
  implements OnGatewayInit, OnGatewayConnection, OnGatewayDisconnect
{
  @WebSocketServer() server: Server;

  constructor(private readonly appService: AppService) {}

  @SubscribeMessage('msgToServer')
  handleMessage(client: Socket, message: Message): void {
    const cleanedMessage = this.appService.sendMessage(message);
    this.server.emit('msgToClient', cleanedMessage);
  }

  afterInit(server: Server) {
    console.log(`Server initialized`);
  }

  handleDisconnect(client: Socket) {
    console.log(`Client disconnected: ${client.id}`);
  }

  handleConnection(client: Socket, ...args: any[]) {
    console.log(`Client connected: ${client.id}`);
  }
}
