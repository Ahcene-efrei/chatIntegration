import { Injectable } from '@nestjs/common';
import { Message } from './message';
import * as fs from 'fs';

const basePath = '../not-censured-chat';
const inFilePath = 'dataIn/message.json';
const outFilePath = 'dataOut/message.json';

@Injectable()
export class AppService {
  async sendMessage(message: Message): Promise<Message> {
    this.writeMessageToFile(message);
    await new Promise((_) => setTimeout(_, 500));
    return this.readMessageFromFile();
  }

  writeMessageToFile(message: Message) {
    fs.writeFileSync(`${basePath}/${inFilePath}`, JSON.stringify(message), {
      flag: 'w',
    });
  }

  readMessageFromFile(): Message {
    const message = fs.readFileSync(`${basePath}/${outFilePath}`);
    return JSON.parse(message.toString());
  }
}
