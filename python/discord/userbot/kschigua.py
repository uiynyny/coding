import os
from time import sleep
import discum
from dotenv import load_dotenv
from discord_webhook import DiscordWebhook

from app import get_webhook

prefix = 'https://cdn.discordapp.com/'
avatar = 'avatars/{user_id}/{user_avatar}.png'

CHANNELS={
    '1021223100139974696':'https://discord.com/api/webhooks/1031596431691223101/WXu7LuTILMqtLSY7sBO0EE-NMa3mnHAasuPr5q6BBQ50IvzCufc_fuFMyTQuJeKZCJsB',
    '1024383145769979924':'https://discord.com/api/webhooks/1031606329833443408/U1JtyflVQP8ocHrmSoTSDl5RSHCLIx2PTNIghRd0vwF2rZcqCCsV_2yDXs8GQWgJzkQS',
    '1024385229248528395':'https://discord.com/api/webhooks/1031606479473614968/h6laDi7UslFPzUX7dIxfDJ3JuHHcrCU7C_akzl-H6T-CebN5m7F5dHFVgE6AfQ7MvT78',
    '1024386258509766666':'https://discord.com/api/webhooks/1032501413726654575/pLtuYZBvTXA8_fHafyPkE0CoHT5o07JvtHrES-s-KYqM1p8C19If-nrfiRMKiqou2QVk',
    '1021223183359168572':'https://discord.com/api/webhooks/1032501203264868362/1eWgkfxTgl8NlBgsKhExMuIV1T_vLKwuRmrPBDDtf2HSMPBo5nYrsQ8kMqSsGK1_kF5D',
    '1024383663909118042':'https://discord.com/api/webhooks/1032501012742807583/-LfxLLdX-E1l26Bb4Rcn0WtFiQr6zRyFqSc7jTdUU786sX4iTLZuC7lcYcu3ElFA-e9K',
    '1027797339789860894':'https://discord.com/api/webhooks/1032500813618225254/mM6o8jVcCRZhs8Veo89RMitfHtaOUoFa1K0zS2GRvWGNeerTUH39i5mSJiM6yI1nY3At',
    '1027800316248330250':'https://discord.com/api/webhooks/1032500683720630272/6qdZza7k7S8mQgkqHE3moyMTJqiFAvSMvNeMMBoYUNmcsD2loAAyFVEqoFtXlp31QdW5',
    '1027802192557641768':'https://discord.com/api/webhooks/1032500405294350366/pqtciDUVs-8ZUT1qrhaSIvU6dNv_OBi4vIOPRQBy8RZFVCYpt6GSWbDhjzGJg93fD8-6',
    '1027955780558802985':'https://discord.com/api/webhooks/1032500309894889563/XOwYqJYDq4zBNybA_e0s2dc7jIxfvBx9b1bdyfohjQvaNJELJv6UDpV6FoM36f4YDFM3',
    '1028025620258623528':'https://discord.com/api/webhooks/1032500137643221014/o6aHEtcCdK0IQttHaVLQSX2hdePMZHXM3erEx7fX0nIS-G_LF7i4OawWwsGBpqnjFOah',
}

load_dotenv()

bot = discum.Client(token=os.getenv('KS'), log=False)

@bot.gateway.command
def on_message(resp):
    # ready_supplemental is sent after ready
    if resp.event.ready_supplemental:
        try:
            user = bot.gateway.session.user
            print("Logged in as {}#{}".format(user["username"],user["discriminator"]))
        except Exception:
            pass
    if resp.event.message:
        m = resp.raw['d']
        guildID = m["guild_id"] if "guild_id" in m else None
        if guildID == "1021201962659753994":
            liaobichuishui(m)

def liaobichuishui(m):
    guildID = m["guild_id"]
    channelID = m["channel_id"]
    username = m["author"]["username"]
    discriminator = m["author"]["discriminator"]
    content = m["content"]
    print(">Chuishui {} channel {} | {}#{}: {}".format(guildID, channelID, username, discriminator, content))
    w=get_webhook(channelID)
    if w:
        w.username, w.avatar_url = get_user_info(m)
        w.embeds, attach = add_attachments(m)
        w.content = m['content'].replace('@','')
        w.content += attach
        w.execute()

def get_webhook(cid):
    if cid in CHANNELS:
        return DiscordWebhook(CHANNELS[cid], rate_limit_retry=True)
    return None

def get_user_info(msg):
    return msg["author"]["username"], prefix + avatar.format(
        user_id=msg["author"]["id"], user_avatar=msg["author"]["avatar"])


def add_attachments(msg):
    embeds = []
    attachments = ''
    if len(msg["embeds"]) > 0:
        embeds = msg["embeds"]
    if len(msg["attachments"]) > 0:
        for att in msg["attachments"]:
            attachments += "\n" + att["url"]
    return embeds, attachments

chs=bot.getGuildChannels('1021201962659753994').json()
# for channel in chs:
#     if channel['id'] in tingchannel:
#         dwh=DiscordWebhook(tingchannel[channel['id']],rate_limit_retry=True)
#         lastid=bot.getMessages(channel['id']).json()[0]['id']
#         id='1031955305891905546'
#         while id != lastid:
#             ms=bot.getMessages(channel['id'],10,afterMessage=id).json()
#             for m in reversed(ms):
#                 dwh.content=m['content']
#                 dwh.embeds=m['embeds']
#                 dwh.embeds, attach = add_attachments(m)
#                 dwh.content += attach
#                 dwh.username, dwh.avatar_url = get_user_info(m)
#                 id=m['id']
#                 dwh.execute()
#                 sleep(1)

bot.gateway.run()