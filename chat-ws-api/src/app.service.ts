import { Injectable } from '@nestjs/common';
import { Message } from './message';
import * as fs from 'fs';
import { v4 as uuidv4 } from 'uuid';

const basePath = '../not-censured-chat';
const dataInPath = 'dataIn';
const dataOutPath = 'dataOut';

@Injectable()
export class AppService {
  async sendMessage(message: Message): Promise<Message> {
    const uuid = uuidv4();
    this.writeMessageToFile(message, uuid);
    await new Promise((_) => setTimeout(_, 1000)); // waiting for spring integration to proceed
    return this.readMessageFromFile(uuid);
  }

  writeMessageToFile(message: Message, uuid: string) {
    fs.writeFileSync(
      `${basePath}/${dataInPath}/${uuid}.json`,
      JSON.stringify(message),
      {
        flag: 'w',
      },
    );
  }

  readMessageFromFile(uuid: string): Message {
    const filePath = `${basePath}/${dataOutPath}/${uuid}.json`;
    const message = fs.readFileSync(filePath);
    fs.unlinkSync(filePath);
    return JSON.parse(message.toString());
  }
}
