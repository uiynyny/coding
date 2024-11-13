import json
import requests

url = 'https://www.redfin.ca/stingray/api/gis?al=3&include_nearby_homes=true&market=ontario&num_homes=400&ord=price-desc&page_number=1&poly=-75.7677 45.26976,-75.6795 45.26976,-75.6795 45.29361,-75.7677 45.29361,-75.7677 45.26976&region_id=2187&region_type=33&sold_within_days=180'
response = requests.get(url,
                        cookies={'RF_PARTY_ID': '56670127',
                                 'RF_AUTH': 'cc3e205201e109705b91479ff8a9ea06a13bf7c7',
                                 'RF_W_AUTH': 'cc3e205201e109705b91479ff8a9ea06a13bf7c7',
                                 'RF_SECURE_AUTH': '3b9233e04fcfc5a2eb36ffbcdf611333f3018547',
                                 'RF_MARKET': 'ontario;'},
                        headers={
                            'Referer': 'https://www.redfin.ca/on/ottawa/filter/sort=hi-price,property-type=house+condo+townhouse,include=sold-6mo,viewport=45.29373:45.27018:-75.68959:-75.73899',
                            'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/97.0.4692.71 Safari/537.36'
                        }
                        )
chunked = response._content[4:]
cleaned_res = chunked.decode('utf8').replace("'", '"')
data = json.loads(cleaned_res)
s = json.dumps(data, indent=4, sort_keys=True)
